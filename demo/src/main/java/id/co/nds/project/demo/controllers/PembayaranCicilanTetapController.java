package id.co.nds.project.demo.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.nds.project.demo.entities.CicilanTetapEntity;
import id.co.nds.project.demo.exceptions.ClientException;
import id.co.nds.project.demo.exceptions.NotFoundException;
import id.co.nds.project.demo.models.CicilanTetapModel;
import id.co.nds.project.demo.models.CicilanTetapRequestModel;
import id.co.nds.project.demo.models.InformasiTransaksiModel;
import id.co.nds.project.demo.models.ResponseModel;
import id.co.nds.project.demo.services.PembayaranCicilanTetapService;

@RestController
@RequestMapping("/pembayaran-cicilan-tetap")
public class PembayaranCicilanTetapController {
  @Autowired
  private PembayaranCicilanTetapService service;

  @GetMapping(value = "/doSearchBayarCicTetap")
  public ResponseEntity<ResponseModel> DoSearchBayarCicTetap(@RequestBody CicilanTetapRequestModel body)
      throws NotFoundException, ClientException {
    ResponseModel response = new ResponseModel();
    List<CicilanTetapModel> list = service.findAllByCriteria(body);

    response.setResponseTime((new Timestamp(System.currentTimeMillis())).toString());
    response.setResponseCode(HttpStatus.OK.toString());
    response.setResponseDescription("doSearchBayarCicTetap Success");
    response.setResponseMessage("Success!");
    response.setData(list);
    return ResponseEntity.ok(response);
  }

  @GetMapping(value = "/doGetDetailTagihanCic")
  public ResponseEntity<ResponseModel> DoGetDetailTagihanCic(@RequestBody CicilanTetapRequestModel body)
      throws ClientException, NotFoundException {
    ResponseModel response = new ResponseModel();
    InformasiTransaksiModel result = service.findByNoTransaksi(body);

    response.setResponseTime((new Timestamp(System.currentTimeMillis())).toString());
    response.setResponseCode(HttpStatus.OK.toString());
    response.setResponseDescription("DoGetDetailTagihanCic Success");
    response.setResponseMessage("Success!");
    response.setData(result);
    return ResponseEntity.ok(response);
  }

  @PutMapping(value = "/doUpdatePembayaran")
  public ResponseEntity<ResponseModel> DoUpdatePembayaran(@RequestBody CicilanTetapRequestModel body)
      throws ClientException {
    ResponseModel response = new ResponseModel();
    CicilanTetapEntity result = service.update(body);

    response.setResponseTime((new Timestamp(System.currentTimeMillis())).toString());
    response.setResponseCode(HttpStatus.OK.toString());
    response.setResponseDescription("DoUpdatePembayaran Success");
    response.setResponseMessage("Success!");
    response.setData(result);
    return ResponseEntity.ok(response);

  }

}
