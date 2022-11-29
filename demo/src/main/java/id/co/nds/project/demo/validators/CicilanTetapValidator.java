package id.co.nds.project.demo.validators;

import id.co.nds.project.demo.exceptions.ClientException;
import id.co.nds.project.demo.exceptions.NotFoundException;

public class CicilanTetapValidator {
  public void validateInteger(Integer num, String entityName) throws ClientException {
    if (num == null) {
      throw new ClientException(entityName + "  is required");
    }
    if (num < 0) {
      throw new ClientException(entityName + " out of range");
    }
  }

  public void isNotNullCheck(Integer id) throws ClientException {
    if (id != null) {
      throw new ClientException("ID  is auto generated, No need for input ID");
    }
  }

  public void isNullCheck(String content, String entityName) throws ClientException {
    if (content == null || content.isEmpty() || content.isBlank()) {
      throw new ClientException(entityName + " is required");
    }
  }

  public void isNullCheck(Object content, String entityName) throws ClientException {
    if (content == null) {
      throw new ClientException(entityName + " is required");
    }
  }

  public void isNullCheck(Object obj) throws NotFoundException {
    if (obj == null) {
      throw new NotFoundException("Data not found");
    }
  }
}
