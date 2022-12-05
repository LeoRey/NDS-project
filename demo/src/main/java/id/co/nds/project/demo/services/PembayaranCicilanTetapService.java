package id.co.nds.project.demo.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import id.co.nds.project.demo.entities.CicilanTetapEntity;
import id.co.nds.project.demo.exceptions.ClientException;
import id.co.nds.project.demo.exceptions.NotFoundException;
import id.co.nds.project.demo.models.CicilanTetapRequestModel;
import id.co.nds.project.demo.repos.CicilanTetapRepo;
import id.co.nds.project.demo.specs.CicilanTetapSpec;
import id.co.nds.project.demo.validators.CommonValidator;

@Service
public class PembayaranCicilanTetapService implements Serializable {
  @Autowired
  private CicilanTetapRepo repo;

  CommonValidator validator = new CommonValidator();

  public List<CicilanTetapEntity> findAllByCriteria(CicilanTetapRequestModel criteria)
      throws NotFoundException, ClientException {
    List<CicilanTetapEntity> list = new ArrayList<>();

    validator.isNullCheck(criteria.getActorId(), "Actor ID");

    repo.FindPembayaranCicilanTetap(criteria).forEach(list::add);
    validator.isNullCheck(list);

    return list;
  }

  public CicilanTetapEntity findByNoTransaksi(CicilanTetapRequestModel requestModel)
      throws ClientException, NotFoundException {
    String noTransaksi = requestModel.getNoTransaksi();
    String actorId = requestModel.getActorId();
    validator.isNullCheck(noTransaksi, "Nomor Transaksi");
    validator.isNullCheck(actorId, "Actor ID");

    CicilanTetapRequestModel criteria = new CicilanTetapRequestModel();
    criteria.setNoTransaksi(noTransaksi);
    criteria.setActorId(actorId);
    CicilanTetapSpec spec = new CicilanTetapSpec(criteria);
    CicilanTetapEntity entity = repo.findBy(spec, null);
    validator.isNullCheck(entity);
    return entity;
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { Exception.class })
  public CicilanTetapEntity update(CicilanTetapRequestModel requestModel)
      throws Exception {
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
    }
    if (errorList.isEmpty()) {
      return null;
    } else {
      for (String eString : errorList) {
        System.out.println(eString);
      }
      throw new Exception(String.join(",", errorList));
    }
  }

}
