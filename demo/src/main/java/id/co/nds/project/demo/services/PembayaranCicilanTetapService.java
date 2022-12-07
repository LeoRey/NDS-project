package id.co.nds.project.demo.services;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import id.co.nds.project.demo.entities.CicilanTetapEntity;
import id.co.nds.project.demo.entities.CustomerEntity;
import id.co.nds.project.demo.entities.ProdukEntity;
import id.co.nds.project.demo.exceptions.ClientException;
import id.co.nds.project.demo.exceptions.NotFoundException;
import id.co.nds.project.demo.models.CicilanTetapModel;
import id.co.nds.project.demo.models.CicilanTetapRequestModel;
import id.co.nds.project.demo.models.InformasiTransaksiModel;
import id.co.nds.project.demo.repos.CicilanTetapRepo;
import id.co.nds.project.demo.repos.CustomerRepo;
import id.co.nds.project.demo.repos.ProdukRepo;
import id.co.nds.project.demo.specs.CicilanTetapSpec;
import id.co.nds.project.demo.validators.CommonValidator;

@Service
public class PembayaranCicilanTetapService implements Serializable {
  @Autowired
  private CicilanTetapRepo repo;
  @Autowired
  private CustomerRepo customerRepo;
  @Autowired
  private ProdukRepo produkRepo;

  CommonValidator validator = new CommonValidator();

  public List<CicilanTetapModel> findAllByCriteria(CicilanTetapRequestModel model)
      throws NotFoundException, ClientException {
    CicilanTetapRequestModel criteria = new CicilanTetapRequestModel();
    criteria.setNoTransaksi(model.getNoTransaksi());
    criteria.setCustId(model.getCustId());
    criteria.setCustName(model.getCustName());
    criteria.setCicDateBegin(model.getCicDateBegin());
    criteria.setCicDateEnd(model.getCicDateEnd());
    criteria.setActorId(model.getActorId());
    validator.isNullCheck(criteria.getActorId(), "Actor ID");

    List<CicilanTetapModel> list = new ArrayList<>();
    CicilanTetapSpec spec = new CicilanTetapSpec(criteria);
    repo.findAll(spec).forEach((cte) -> {
      CicilanTetapModel ctm = new CicilanTetapModel();
      CustomerEntity c = customerRepo.findById(cte.getIdPelanggan()).orElse(null);
      ctm.setNoTransaksi(cte.getNoTransaksi());
      ctm.setTglTransaksi(cte.getCreatedDate().toString());
      ctm.setIdPelanggan(cte.getIdPelanggan());
      ctm.setNoKTP(c != null ? c.getKtp() : null);
      ctm.setNamaPelanggan(c != null ? c.getNama() : null);
      ctm.setCicilanKe(cte.getCicilanKe());
      ctm.setTotalTagihan(cte.getTotalTagihan());
      ctm.setStatusCicilan(cte.getStatusCicilan());
      ctm.setTglAktifCicilan(cte.getTglAktifCicilan());
      ctm.setTglJatuhTempoCicilan(cte.getTglJatuhTempoCicilan());

      list.add(ctm);
    });
    validator.isNullCheck(list);

    return list;
  }

  public InformasiTransaksiModel findByNoTransaksi(CicilanTetapRequestModel requestModel)
      throws ClientException, NotFoundException {
    String noTransaksi = requestModel.getNoTransaksi();
    String actorId = requestModel.getActorId();
    validator.isNullCheck(noTransaksi, "Nomor Transaksi");
    validator.isNullCheck(actorId, "Actor ID");

    CicilanTetapRequestModel criteria = new CicilanTetapRequestModel();
    criteria.setNoTransaksi(noTransaksi);
    criteria.setActorId(actorId);
    CicilanTetapSpec spec = new CicilanTetapSpec(criteria);

    CicilanTetapEntity cte = repo.findBy(spec, null);
    validator.isNullCheck(cte);

    CustomerEntity ce = customerRepo.findById(cte.getIdPelanggan()).orElse(null);
    validator.isNullCheck(ce);

    ProdukEntity pe = produkRepo.findById(cte.getProdukTransaksi()).orElse(null);
    validator.isNullCheck(ce);

    InformasiTransaksiModel itm = new InformasiTransaksiModel();
    itm.setNoTransaksi(noTransaksi);
    itm.setPelanggan(ce.getId() + " - " + ce.getNama());
    itm.setTglTransaksi(cte.getCreatedDate().toString());
    itm.setTotalNilaiPinjaman(cte.getTotalPinjaman());
    itm.setTenor(cte.getTenor());
    itm.setTglJatuhTempo(cte.getTglJatuhTempoCicilan());
    itm.setProdukTransaksi(cte.getProdukTransaksi());
    itm.setNamaProduk(pe.getNama());
    itm.setKeteranganproduk(pe.getKeterangan());
    itm.setTotalKewajiban(cte.getCicilanPokok() + cte.getBiayaPenyimpanan());
    itm.setTotalDenda(cte.getTotalDenda());
    itm.setTotalPembayaran(cte.getTotalPembayaran());
    itm.setSisaKewajiban();

    return itm;
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { Exception.class })
  public CicilanTetapEntity update(CicilanTetapRequestModel requestModel) throws ClientException {
    String noTransaksi = requestModel.getNoTransaksi();
    String metode = requestModel.getMetodeBayar();
    Integer diskon = requestModel.getDiskon();
    Integer jumlah = requestModel.getJumlahInputPembayaran();
    List<Integer> selectedCic = requestModel.getSelectedNoCic();

    // Validation
    validator.isNullCheck(noTransaksi, "Nomor Transaksi");
    validator.isNullCheck(metode, "Metode Pembayaran");
    validator.validateInteger(diskon, "Diskon");
    validator.validateInteger(jumlah, "Jumlah Input Pembayaran");
    validator.isNullCheck(selectedCic, "Pilihan cicilan");

    // Process
    CicilanTetapRequestModel criteria = new CicilanTetapRequestModel();
    criteria.setNoTransaksi(noTransaksi);
    criteria.setMetodeBayar(metode);
    criteria.setDiskon(diskon);
    criteria.setJumlahInputPembayaran(jumlah);
    criteria.setSelectedNoCic(selectedCic);
    CicilanTetapSpec spec = new CicilanTetapSpec(criteria);
    List<CicilanTetapEntity> list = new ArrayList<>();
    repo.findAll(spec).forEach(list::add);

    ArrayList<String> errorList = new ArrayList<String>();
    for (CicilanTetapEntity entity : list) {
      // Calculation here
      entity.setStatusCicilan("DIBAYAR");
      entity.setTanggalBayar(new Timestamp(System.currentTimeMillis()));
    }
    if (errorList.isEmpty()) {
      return null;
    } else {
      for (String eString : errorList) {
        System.out.println(eString);
      }
      throw new ClientException(String.join(",", errorList));
    }
  }

}
