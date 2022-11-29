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
import id.co.nds.project.demo.models.CicilanTetapRequestModel;
import id.co.nds.project.demo.models.ResponseModel;
import id.co.nds.project.demo.services.PembayaranCicilanTetapService;

@RestController
@RequestMapping("/pembayaran-cicilan-tetap")
public class PembayaranCicilanTetapController {
  @Autowired
  private PembayaranCicilanTetapService service;

  @GetMapping(value = "/doSearchBayarCicTetap")
  public ResponseEntity<ResponseModel> DoSearchBayarCicTetap(@RequestBody CicilanTetapRequestModel body) {
    ResponseModel response = new ResponseModel();
    response.setResponseTime((new Timestamp(System.currentTimeMillis())).toString());
    try {
      List<CicilanTetapEntity> list = service.findAllByCriteria(body);

      response.setResponseCode(HttpStatus.OK.toString());
      response.setResponseDescription("doSearchBayarCicTetap Success");
      response.setResponseMessage("Success!");
      response.setData(list);
      return ResponseEntity.ok(response);
    } catch (ClientException e) {
      response.setResponseCode(HttpStatus.BAD_REQUEST.toString());
      response.setResponseDescription("Request data is missing or incorrect");
      response.setResponseMessage(e.getMessage());
      return ResponseEntity.badRequest().body(response);
    } catch (NotFoundException e) {
      response.setResponseCode(HttpStatus.NO_CONTENT.toString());
      response.setResponseDescription("No data is found from database.");
      response.setResponseMessage(e.getMessage());
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    } catch (Exception e) {
      response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
      response.setResponseDescription("Internal Server Error");
      response.setResponseMessage(e.getMessage());
      return ResponseEntity.internalServerError().body(response);
    }
  }

  @GetMapping(value = "/doGetDetailTagihanCic")
  public ResponseEntity<ResponseModel> DoGetDetailTagihanCic(@RequestBody CicilanTetapRequestModel body) {
    ResponseModel response = new ResponseModel();
    response.setResponseTime((new Timestamp(System.currentTimeMillis())).toString());
    try {
      CicilanTetapEntity result = service.findByNoTransaksi(body);

      response.setResponseCode(HttpStatus.OK.toString());
      response.setResponseDescription("DoGetDetailTagihanCic Success");
      response.setResponseMessage("Success!");
      response.setData(result);
      return ResponseEntity.ok(response);
    } catch (ClientException e) {
      response.setResponseCode(HttpStatus.BAD_REQUEST.toString());
      response.setResponseDescription("Request data is missing or incorrect");
      response.setResponseMessage(e.getMessage());
      return ResponseEntity.badRequest().body(response);
    } catch (NotFoundException e) {
      response.setResponseCode(HttpStatus.NO_CONTENT.toString());
      response.setResponseDescription("No data is found from database.");
      response.setResponseMessage(e.getMessage());
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    } catch (Exception e) {
      response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
      response.setResponseDescription("Internal Server Error");
      response.setResponseMessage(e.getMessage());
      return ResponseEntity.internalServerError().body(response);
    }
  }

  @PutMapping(value = "/doUpdatePembayaran")
  public ResponseEntity<ResponseModel> DoUpdatePembayaran(@RequestBody CicilanTetapRequestModel body) {
    ResponseModel response = new ResponseModel();
    response.setResponseTime((new Timestamp(System.currentTimeMillis())).toString());
    try {
      CicilanTetapEntity result = service.update(body);

      response.setResponseCode(HttpStatus.OK.toString());
      response.setResponseDescription("DoUpdatePembayaran Success");
      response.setResponseMessage("Success!");
      response.setData(result);
      return ResponseEntity.ok(response);
    } catch (ClientException e) {
      response.setResponseCode(HttpStatus.BAD_REQUEST.toString());
      response.setResponseDescription("Request data is missing or incorrect");
      response.setResponseMessage(e.getMessage());
      return ResponseEntity.badRequest().body(response);
    } catch (NotFoundException e) {
      response.setResponseCode(HttpStatus.NO_CONTENT.toString());
      response.setResponseDescription("No data is found from database.");
      response.setResponseMessage(e.getMessage());
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    } catch (Exception e) {
      response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
      response.setResponseDescription("Internal Server Error");
      response.setResponseMessage(e.getMessage());
      return ResponseEntity.internalServerError().body(response);
    }
  }

}
