package id.co.nds.project.demo.models;

import java.math.BigDecimal;
// TODO: Remove this
public class CicilanTetapModel {
  private String noTransaksi;
  private String tglTransaksi;
  private String idPelanggan;
  private String noKTP;
  private String namaPelanggan;
  private String cicilanKe;
  private BigDecimal totalTagihan;
  private String statusCicilan;
  private String tglAktifCicilan;
  private String tglJatuhTempoCicilan;

  public String getNoTransaksi() {
    return noTransaksi;
  }

  public void setNoTransaksi(String noTransaksi) {
    this.noTransaksi = noTransaksi;
  }

  public String getTglTransaksi() {
    return tglTransaksi;
  }

  public void setTglTransaksi(String tglTransaksi) {
    this.tglTransaksi = tglTransaksi;
  }

  public String getIdPelanggan() {
    return idPelanggan;
  }

  public void setIdPelanggan(String idPelanggan) {
    this.idPelanggan = idPelanggan;
  }

  public String getNoKTP() {
    return noKTP;
  }

  public void setNoKTP(String noKTP) {
    this.noKTP = noKTP;
  }

  public String getnamaPelanggan() {
    return namaPelanggan;
  }

  public void setnamaPelanggan(String namaPelanggan) {
    this.namaPelanggan = namaPelanggan;
  }

  public String getCicilanKe() {
    return cicilanKe;
  }

  public void setCicilanKe(String cicilanKe) {
    this.cicilanKe = cicilanKe;
  }

  public BigDecimal getTotalTagihan() {
    return totalTagihan;
  }

  public void setTotalTagihan(BigDecimal totalTagihan) {
    this.totalTagihan = totalTagihan;
  }

  public String getStatusCicilan() {
    return statusCicilan;
  }

  public void setStatusCicilan(String statusCicilan) {
    this.statusCicilan = statusCicilan;
  }

  public String getTglAktifCicilan() {
    return tglAktifCicilan;
  }

  public void setTglAktifCicilan(String tglAktifCicilan) {
    this.tglAktifCicilan = tglAktifCicilan;
  }

  public String getTglJatuhTempoCicilan() {
    return tglJatuhTempoCicilan;
  }

  public void setTglJatuhTempoCicilan(String tglJatuhTempoCicilan) {
    this.tglJatuhTempoCicilan = tglJatuhTempoCicilan;
  }
}
