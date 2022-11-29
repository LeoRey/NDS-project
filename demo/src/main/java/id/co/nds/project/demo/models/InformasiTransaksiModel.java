package id.co.nds.project.demo.models;

public class InformasiTransaksiModel {
  private String pelanggan;
  private String tglTransaksi;
  private String noTransaksi;
  private Integer totalNilaiPinjaman;
  private Integer tenor;
  private String tglJatuhTempo;
  private String produkTransaksi;
  private String namaProduk;
  private String keteranganproduk;
  private Integer totalKewajiban;
  private Integer totalDenda;
  private Integer totalPembayaran;
  private Integer sisaKewajiban;

  public String getPelanggan() {
    return pelanggan;
  }

  public void setPelanggan(String pelanggan) {
    this.pelanggan = pelanggan;
  }

  public String getTglTransaksi() {
    return tglTransaksi;
  }

  public void setTglTransaksi(String tglTransaksi) {
    this.tglTransaksi = tglTransaksi;
  }

  public String getNoTransaksi() {
    return noTransaksi;
  }

  public void setNoTransaksi(String noTransaksi) {
    this.noTransaksi = noTransaksi;
  }

  public Integer getTotalNilaiPinjaman() {
    return totalNilaiPinjaman;
  }

  public void setTotalNilaiPinjaman(Integer totalNilaiPinjaman) {
    this.totalNilaiPinjaman = totalNilaiPinjaman;
  }

  public Integer getTenor() {
    return tenor;
  }

  public void setTenor(Integer tenor) {
    this.tenor = tenor;
  }

  public String getTglJatuhTempo() {
    return tglJatuhTempo;
  }

  public void setTglJatuhTempo(String tglJatuhTempo) {
    this.tglJatuhTempo = tglJatuhTempo;
  }

  public String getProdukTransaksi() {
    return produkTransaksi;
  }

  public void setProdukTransaksi(String produkTransaksi) {
    this.produkTransaksi = produkTransaksi;
  }

  public String getNamaProduk() {
    return namaProduk;
  }

  public void setNamaProduk(String namaProduk) {
    this.namaProduk = namaProduk;
  }

  public String getKeteranganproduk() {
    return keteranganproduk;
  }

  public void setKeteranganproduk(String keteranganproduk) {
    this.keteranganproduk = keteranganproduk;
  }

  public Integer getTotalKewajiban() {
    return totalKewajiban;
  }

  public void setTotalKewajiban(Integer totalKewajiban) {
    this.totalKewajiban = totalKewajiban;
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

  public Integer getSisaKewajiban() {
    return sisaKewajiban;
  }

  public void setSisaKewajiban() {
    this.sisaKewajiban = this.totalKewajiban + this.totalDenda;
  }
}
