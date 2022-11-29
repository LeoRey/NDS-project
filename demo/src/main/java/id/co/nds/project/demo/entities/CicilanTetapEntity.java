package id.co.nds.project.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "CicilanTetap")
public class CicilanTetapEntity {
  @Id
  @Column(name = "no_transaksi")
  private String noTransaksi;

  @JoinColumn(name = "id_pelanggan", referencedColumnName = "customer_id")
  @Column(name = "id_pelanggan")
  private String idPelanggan;

  @Column(name = "tgl_cicilan_start")
  private String tglCicilanStart;

  @Column(name = "tgl_cicilan_end")
  private String tglCicilanEnd;

  @Column(name = "cicilan_ke")
  private String cicilanKe;

  @Column(name = "total_tagihan")
  private Integer totalTagihan;

  @Column(name = "status_cicilan")
  private String statusCicilan;

  @Column(name = "tgl_aktif_cicilan")
  private String tglAktifCicilan;

  @Column(name = "tgl_jatuh_tempo_cicilan")
  private String tglJatuhTempoCicilan;

  public String getNoTransaksi() {
    return noTransaksi;
  }

  public void setNoTransaksi(String noTransaksi) {
    this.noTransaksi = noTransaksi;
  }

  public String getIdPelanggan() {
    return idPelanggan;
  }

  public void setIdPelanggan(String idPelanggan) {
    this.idPelanggan = idPelanggan;
  }

  public String getTglCicilanStart() {
    return tglCicilanStart;
  }

  public void setTglCicilanStart(String tglCicilanStart) {
    this.tglCicilanStart = tglCicilanStart;
  }

  public String getTglCicilanEnd() {
    return tglCicilanEnd;
  }

  public void setTglCicilanEnd(String tglCicilanEnd) {
    this.tglCicilanEnd = tglCicilanEnd;
  }

  public String getCicilanKe() {
    return cicilanKe;
  }

  public void setCicilanKe(String cicilanKe) {
    this.cicilanKe = cicilanKe;
  }

  public Integer getTotalTagihan() {
    return totalTagihan;
  }

  public void setTotalTagihan(Integer totalTagihan) {
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
