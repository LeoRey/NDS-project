package id.co.nds.project.demo.validators;

import id.co.nds.project.demo.exceptions.ClientException;
import id.co.nds.project.demo.exceptions.NotFoundException;

public class CommonValidator {
  public void validateInteger(Integer num, String entityName) throws ClientException {
    if (num == null) {
      throw new ClientException(entityName + "  is required");
    }
    if (num < 0) {
      throw new ClientException(entityName + " out of range");
    }
  }

  public void isNotNullCheck(String id) throws ClientException {
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

  public void isNumber(String number, String entityName) throws ClientException {
    try {
      Integer.parseInt(number);
    } catch (NumberFormatException e) {
      throw new ClientException(entityName + " content is not a Number");
    }
  }

  public void isDouble(String number, String entityName) throws ClientException {
    try {
      Double.parseDouble(number);
    } catch (NumberFormatException e) {
      throw new ClientException(entityName + " content is not a Double");
    }
  }

  public void isNumberInRange(Integer number, int minRange, int maxRange, String entityName) throws ClientException {
    if (maxRange == 0) {
      if (number < minRange) {
        throw new ClientException(
            String.format("%s out of range. It must be above %d", entityName, minRange));
      }
    } else {
      if (number > maxRange || number < minRange) {
        throw new ClientException(
            String.format("%s out of range. It must be between %d to %d", entityName, minRange, maxRange));
      }
    }
  }

  public void isNumberInRange(Double number, Long minRange, Long maxRange, String entityName) throws ClientException {
    if (maxRange == 0) {
      if (number < minRange) {
        throw new ClientException(
            String.format("%s out of range. It must be above %d", entityName, minRange));
      }
    } else {
      if (number > maxRange || number < minRange) {
        throw new ClientException(
            String.format("%s out of range. It must be between %d to %d", entityName, minRange, maxRange));
      }
    }
  }

}
