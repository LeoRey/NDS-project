package id.co.nds.project.demo.exceptions;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import id.co.nds.project.demo.models.ResponseModel;

/* This will remove try catch block from controller as  it will be handled here */
@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(value = { NotFoundException.class })
  public ResponseEntity<ResponseModel> notFoundException(NotFoundException ex, WebRequest request) {
    ResponseModel response = new ResponseModel();

    response.setResponseTime((new Timestamp(System.currentTimeMillis())).toString());
    response.setResponseCode(HttpStatus.NO_CONTENT.toString());
    response.setResponseDescription("No data is found from database.");
    response.setResponseMessage(ex.getMessage());
    return new ResponseEntity<ResponseModel>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = { ClientException.class })
  public ResponseEntity<ResponseModel> clientException(ClientException ex, WebRequest request) {
    ResponseModel response = new ResponseModel();

    response.setResponseTime((new Timestamp(System.currentTimeMillis())).toString());
    response.setResponseCode(HttpStatus.BAD_REQUEST.toString());
    response.setResponseDescription("Request data is missing or incorrect");
    response.setResponseMessage(ex.getMessage());
    return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = { Exception.class })
  public ResponseEntity<ResponseModel> exception(Exception ex, WebRequest request) {
    ResponseModel response = new ResponseModel();

    response.setResponseTime((new Timestamp(System.currentTimeMillis())).toString());
    response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    response.setResponseDescription("Internal Server Error");
    response.setResponseMessage(ex.getMessage());
    ex.printStackTrace();
    return new ResponseEntity<ResponseModel>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
