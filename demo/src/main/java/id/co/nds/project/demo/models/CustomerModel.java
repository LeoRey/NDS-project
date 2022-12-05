package id.co.nds.project.demo.models;

public class CustomerModel extends RecordModel {
  private String custId;
  private String custName;
  private String custKtp;
  private String custStatus;
  private String custHp;
  private String custJenisUsahaId;
  private String custJk;
  private String custLimitTxn;

  public String getCustId() {
    return custId;
  }

  public void setCustId(String custId) {
    this.custId = custId;
  }

  public String getCustName() {
    return custName;
  }

  public void setCustName(String custName) {
    this.custName = custName;
  }

  public String getCustKtp() {
    return custKtp;
  }

  public void setCustKtp(String custKtp) {
    this.custKtp = custKtp;
  }

  public String getCustStatus() {
    return custStatus;
  }

  public void setCustStatus(String custStatus) {
    this.custStatus = custStatus;
  }

  public String getCustHp() {
    return custHp;
  }

  public void setCustHp(String custHp) {
    this.custHp = custHp;
  }

  public String getCustJenisUsahaId() {
    return custJenisUsahaId;
  }

  public void setCustJenisUsahaId(String custJenisUsahaId) {
    this.custJenisUsahaId = custJenisUsahaId;
  }

  public String getCustJk() {
    return custJk;
  }

  public void setCustJk(String custJk) {
    this.custJk = custJk;
  }

  public String getCustLimitTxn() {
    return custLimitTxn;
  }

  public void setCustLimitTxn(String custLimitTxn) {
    this.custLimitTxn = custLimitTxn;
  }

}
