package id.co.nds.project.demo.models;

import java.util.List;

public class CicilanTetapRequestModel {
  private String noTransaksi;
  private String custId;
  private String custName;
  private String metodeBayar;
  private String cicDateBegin;
  private String cicDateEnd;
  private String actorId;
  private Integer diskon;
  private Integer jumlahInputPembayaran;
  private List<Integer> selectedNoCic;

  public String getNoTransaksi() {
    return noTransaksi;
  }

  public void setNoTransaksi(String noTransaksi) {
    this.noTransaksi = noTransaksi;
  }

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

  public String getMetodeBayar() {
    return metodeBayar;
  }

  public void setMetodeBayar(String metodeBayar) {
    this.metodeBayar = metodeBayar;
  }

  public String getCicDateBegin() {
    return cicDateBegin;
  }

  public void setCicDateBegin(String cicDateBegin) {
    this.cicDateBegin = cicDateBegin;
  }

  public String getCicDateEnd() {
    return cicDateEnd;
  }

  public void setCicDateEnd(String cicDateEnd) {
    this.cicDateEnd = cicDateEnd;
  }

  public String getActorId() {
    return actorId;
  }

  public void setActorId(String actorId) {
    this.actorId = actorId;
  }

  public Integer getDiskon() {
    return diskon;
  }

  public void setDiskon(Integer diskon) {
    this.diskon = diskon;
  }

  public Integer getJumlahInputPembayaran() {
    return jumlahInputPembayaran;
  }

  public void setJumlahInputPembayaran(Integer jumlahInputPembayaran) {
    this.jumlahInputPembayaran = jumlahInputPembayaran;
  }

  public List<Integer> getSelectedNoCic() {
    return selectedNoCic;
  }

  public void setSelectedNoCic(List<Integer> selectedNoCic) {
    this.selectedNoCic = selectedNoCic;
  }
}
