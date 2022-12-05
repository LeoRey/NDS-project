package id.co.nds.project.demo.services;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.project.demo.entities.CustomerEntity;
import id.co.nds.project.demo.entities.JenisUsahaEntity;
import id.co.nds.project.demo.exceptions.ClientException;
import id.co.nds.project.demo.exceptions.NotFoundException;
import id.co.nds.project.demo.models.CustomerModel;
import id.co.nds.project.demo.repos.CustomerRepo;
import id.co.nds.project.demo.repos.JenisUsahaRepo;
import id.co.nds.project.demo.specs.CustomerSpec;
import id.co.nds.project.demo.utils.validationUtil;
import id.co.nds.project.demo.validators.CustomerValidator;

@Service
public class CustomerService implements Serializable {
  @Autowired
  private CustomerRepo repo;
  @Autowired
  private JenisUsahaRepo repoUsaha;

  CustomerValidator validator = new CustomerValidator();

  public List<CustomerEntity> findAllByCriteria(CustomerModel request)
      throws NotFoundException, ClientException {
    List<CustomerEntity> list = new ArrayList<>();

    validator.isNullCheck(request.getActorId(), "Actor ID");

    CustomerSpec spec = new CustomerSpec(request);

    repo.findAll(spec).forEach(list::add);
    validator.isNullCheck(list);

    return list;
  }

  public CustomerEntity findById(CustomerModel requestModel)
      throws ClientException, NotFoundException {
    String id = requestModel.getCustId();
    Integer actorId = requestModel.getActorId();
    validator.isNullCheck(id, "Id Pelanggan");
    validator.isNullCheck(actorId, "Actor ID");

    CustomerEntity entity = repo.findById(id).orElse(null);
    validator.isNullCheck(entity);
    return entity;
  }

  public CustomerEntity create(CustomerModel requestModel) throws ClientException, NotFoundException {
    return insertEntity(requestModel, false);
  }

  public CustomerEntity update(CustomerModel requestModel) throws ClientException, NotFoundException {
    return insertEntity(requestModel, true);
  }

  private CustomerEntity insertEntity(CustomerModel requestModel, boolean update)
      throws ClientException, NotFoundException {
    String ID = requestModel.getCustId();
    String name = requestModel.getCustName();
    String hp = requestModel.getCustHp();
    String jenisKelamin = requestModel.getCustJk();
    String ktp = requestModel.getCustKtp();
    Integer jenisUsaha = Integer.parseInt(requestModel.getCustJenisUsahaId());
    String limit = requestModel.getCustLimitTxn();
    Integer actorId = requestModel.getActorId();

    // Validation
    validator.validateKtp(ktp);
    if (update) {
      validator.isNullCheck(ID, "Id pelanggan");
      if (repo.countByKTP(ktp, ID) > 0) {
        throw new ClientException("Nomor KTP sudah ada");
      }
    } else {
      validator.isNotNullCheck(ID);
      if (repo.countByKTP(ktp) > 0) {
        throw new ClientException("Nomor KTP sudah ada");
      }
    }
    validator.isNullCheck(name, "Nama Pelanggan");
    validator.isNullCheck(jenisUsaha, "Jenis Usaha");
    validator.isNullCheck(actorId, "Actor ID");

    validator.validateHp(hp);
    validator.validateJenisKelamin(jenisKelamin);
    validator.validateLimit(limit);
    if (!validationUtil.isEmpty(hp)) {
      validator.validateHp(hp);
      if (update) {
        if (repo.countByCallNumber(hp, ID) > 0) {
          throw new ClientException("Nomor HP sudah ada");
        }
      } else {
        if (repo.countByCallNumber(hp) > 0) {
          throw new ClientException("Nomor HP sudah ada");
        }
      }
    }

    // Process
    CustomerEntity CustomerEntity = new CustomerEntity();
    if (update) {
      CustomerEntity = findById(requestModel);
      CustomerEntity.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
      CustomerEntity.setUpdaterId(actorId);
    } else {
      CustomerEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
      CustomerEntity.setCreatorId(actorId);
    }
    CustomerEntity.setNama(name);
    CustomerEntity.setJenisUsaha(jenisUsaha);
    CustomerEntity.setJenisKelamin(jenisKelamin.charAt(0));
    CustomerEntity.setKtp(ktp);
    CustomerEntity.setMaxLimitPinjaman(Double.parseDouble(limit));
    if (!validationUtil.isEmpty(hp)) {
      CustomerEntity.setHp(hp);
    }
    CustomerEntity.setStatus('A');

    return repo.save(CustomerEntity);
  }

  public CustomerEntity delete(CustomerModel requestModel) throws ClientException, NotFoundException {
    String ID = requestModel.getCustId();
    Integer actorId = requestModel.getActorId();

    // Validation
    validator.isNullCheck(ID, "Id pelanggan");
    validator.isNullCheck(actorId, "Actor ID");

    // Process
    CustomerEntity entity = new CustomerEntity();
    entity = findById(requestModel);

    if (entity.getStatus() == 'N') {
      throw new ClientException(String.format("Pelanggan  dengan id %d sudah pernah dihapus", ID));
    }

    entity.setStatus('N');
    entity.setDeletedDate(new Timestamp(System.currentTimeMillis()));
    entity.setDeleterId(actorId);
    return repo.save(entity);
  }

  public List<JenisUsahaEntity> getAllJenisUsahaEntity() {
    return repoUsaha.findAll();
  }
}
