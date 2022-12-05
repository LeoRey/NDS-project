package id.co.nds.project.demo.validators;

import id.co.nds.project.demo.exceptions.ClientException;

public class CustomerValidator extends CommonValidator {
  public void validateKtp(String ktp) throws ClientException {
    isNullCheck(ktp, "ktp");
    isNumber(ktp, "ktp");
    if (ktp.length() != 16) {
      throw new ClientException("KTP must contain 16 digits");
    }
  }

  public void validateHp(String hp) throws ClientException {
    String lastDigit;
    if (hp.startsWith("0")) {
      lastDigit = hp.substring(1);
    } else if (hp.startsWith("+62")) {
      lastDigit = hp.substring(3);
    } else {
      throw new ClientException("Call number starts with 0 or +62");
    }
    if (lastDigit.length() > 12 || lastDigit.length() < 9) {
      throw new ClientException("Insufficient length of hp number. It must be 9 to 12 digits after prefix");
    }
    isNumber(lastDigit, "Nomor HP pelanggan");
  }

  public void validateJenisKelamin(String jenisKelamin) throws ClientException {
    isNullCheck(jenisKelamin, "Jenis kelamin");
    if (jenisKelamin != "W" || jenisKelamin != "P") {
      throw new ClientException("Jenis kelamin hanya bisa P atau W");
    }
  }

  public void validateLimit(String limit) throws ClientException {
    isNullCheck(limit, "Limit transaksi");
    isDouble(limit, "Limit transaksi");
    isNumberInRange(Double.parseDouble(limit), 1000000L, 3000000000L, "Limit transaksi");
  }
}
