package id.co.nds.project.demo.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.nds.project.demo.entities.CustomerEntity;
import id.co.nds.project.demo.entities.JenisUsahaEntity;
import id.co.nds.project.demo.exceptions.ClientException;
import id.co.nds.project.demo.exceptions.NotFoundException;
import id.co.nds.project.demo.models.CustomerModel;
import id.co.nds.project.demo.models.ResponseModel;
import id.co.nds.project.demo.services.CustomerService;

@RestController
@RequestMapping("/pelanggan")
public class CustomerController {
  @Autowired
  private CustomerService service;

  @GetMapping(value = "/doSearchPelanggan")
  public ResponseEntity<ResponseModel> DoSearchPelanggan(@RequestBody CustomerModel body)
      throws NotFoundException, ClientException {
    ResponseModel response = new ResponseModel();
    List<CustomerEntity> list = service.findAllByCriteria(body);

    response.setResponseTime((new Timestamp(System.currentTimeMillis())).toString());
    response.setResponseCode(HttpStatus.OK.toString());
    response.setResponseDescription("DoSearchPelanggan Success");
    response.setResponseMessage("Success!");
    response.setData(list);
    return ResponseEntity.ok(response);
  }

  @GetMapping(value = "/doGetDetailPelanggan")
  public ResponseEntity<ResponseModel> DoGetDetailPelanggan(@RequestBody CustomerModel body)
      throws ClientException, NotFoundException {
    ResponseModel response = new ResponseModel();
    CustomerEntity result = service.findById(body);

    response.setResponseTime((new Timestamp(System.currentTimeMillis())).toString());
    response.setResponseCode(HttpStatus.OK.toString());
    response.setResponseDescription("DoGetDetailPelanggan Success");
    response.setResponseMessage("Success!");
    response.setData(result);
    return ResponseEntity.ok(response);
  }

  @PostMapping(value = "/doInsertPelanggan")
  public ResponseEntity<ResponseModel> DoInsertPelanggan(@RequestBody CustomerModel body)
      throws ClientException, NotFoundException {
    ResponseModel response = new ResponseModel();
    CustomerEntity result = service.create(body);

    response.setResponseTime((new Timestamp(System.currentTimeMillis())).toString());
    response.setResponseCode(HttpStatus.OK.toString());
    response.setResponseDescription("DoInsertPelanggan Success");
    response.setResponseMessage("Success!");
    response.setData(result);
    return ResponseEntity.ok(response);
  }

  @PutMapping(value = "/doUpdatePelanggan")
  public ResponseEntity<ResponseModel> DoUpdatePelanggan(@RequestBody CustomerModel body)
      throws ClientException, NotFoundException {
    ResponseModel response = new ResponseModel();
    CustomerEntity result = service.update(body);

    response.setResponseTime((new Timestamp(System.currentTimeMillis())).toString());
    response.setResponseCode(HttpStatus.OK.toString());
    response.setResponseDescription("DoUpdatePelanggan Success");
    response.setResponseMessage("Sukses Ubah Data Pelanggan dengan " + result.getId());
    response.setData(result);
    return ResponseEntity.ok(response);

  }

  @DeleteMapping(value = "/doDeletePelanggan")
  public ResponseEntity<ResponseModel> DoDeletePelanggan(@RequestBody CustomerModel body)
      throws ClientException, NotFoundException {
    ResponseModel response = new ResponseModel();
    CustomerEntity result = service.delete(body);

    response.setResponseTime((new Timestamp(System.currentTimeMillis())).toString());
    response.setResponseCode(HttpStatus.OK.toString());
    response.setResponseDescription("DoDeletePelanggan Success");
    response.setResponseMessage("Sukses Hapus Data Pelanggan " + result.getId());
    response.setData(result);
    return ResponseEntity.ok(response);

  }

  @GetMapping(value = "/doGetListJenisUsaha")
  public ResponseEntity<ResponseModel> DoGetListJenisUsaha() {
    ResponseModel response = new ResponseModel();
    List<JenisUsahaEntity> list = service.getAllJenisUsahaEntity();

    response.setResponseTime((new Timestamp(System.currentTimeMillis())).toString());
    response.setResponseCode(HttpStatus.OK.toString());
    response.setResponseDescription("DoGetListJenisUsaha Success");
    response.setResponseMessage("Success!");
    response.setData(list);
    return ResponseEntity.ok(response);

  }

}
