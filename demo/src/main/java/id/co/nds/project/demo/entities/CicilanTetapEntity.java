package id.co.nds.project.demo.entities;

import java.sql.Timestamp;

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

  @JoinColumn(name = "id_pelanggan", referencedColumnName = "id")
  @Column(name = "id_pelanggan")
  private String idPelanggan;

  @JoinColumn(name = "produk_transaksi", referencedColumnName = "id")
  @Column(name = "produk_transaksi")
  private Integer produkTransaksi;

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

  @Column(name = "total_pinjaman")
  private Integer totalPinjaman;

  @Column(name = "tenor")
  private Integer tenor;

  @Column(name = "cicilan_pokok")
  private Integer cicilanPokok;

  @Column(name = "biaya_penyimpanan")
  private Integer biayaPenyimpanan;

  @Column(name = "total_denda")
  private Integer totalDenda;

  @Column(name = "total_pembayaran")
  private Integer totalPembayaran;

  @Column(name = "tanggal_bayar")
  private Timestamp tanggalBayar;

  @Column(name = "created_date")
  private Timestamp createdDate;

  @Column(name = "updated_date")
  private Timestamp updatedDate;

  @Column(name = "creator_id")
  private Integer creatorId;

  @Column(name = "updater_id")
  private Integer updaterId;

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

  public Integer getProdukTransaksi() {
    return produkTransaksi;
  }

  public void setProdukTransaksi(Integer produkTransaksi) {
    this.produkTransaksi = produkTransaksi;
  }

  public Timestamp getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Timestamp createdDate) {
    this.createdDate = createdDate;
  }

  public Timestamp getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(Timestamp updatedDate) {
    this.updatedDate = updatedDate;
  }

  public Integer getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(Integer creatorId) {
    this.creatorId = creatorId;
  }

  public Integer getUpdaterId() {
    return updaterId;
  }

  public void setUpdaterId(Integer updaterId) {
    this.updaterId = updaterId;
  }

  public Integer getTotalPinjaman() {
    return totalPinjaman;
  }

  public void setTotalPinjaman(Integer totalPinjaman) {
    this.totalPinjaman = totalPinjaman;
  }

  public Integer getTenor() {
    return tenor;
  }

  public void setTenor(Integer tenor) {
    this.tenor = tenor;
  }

  public Integer getCicilanPokok() {
    return cicilanPokok;
  }

  public void setCicilanPokok(Integer cicilanPokok) {
    this.cicilanPokok = cicilanPokok;
  }

  public Integer getBiayaPenyimpanan() {
    return biayaPenyimpanan;
  }

  public void setBiayaPenyimpanan(Integer biayaPenyimpanan) {
    this.biayaPenyimpanan = biayaPenyimpanan;
  }

  public Integer getTotalDenda() {
    return totalDenda;
  }

  public void setTotalDenda(Integer totalDenda) {
    this.totalDenda = totalDenda;
  }

  public Integer getTotalPembayaran() {
    return totalPembayaran;
  }

  public void setTotalPembayaran(Integer totalPembayaran) {
    this.totalPembayaran = totalPembayaran;
  }

  public Timestamp getTanggalBayar() {
    return tanggalBayar;
  }

  public void setTanggalBayar(Timestamp tanggalBayar) {
    this.tanggalBayar = tanggalBayar;
  }
}
