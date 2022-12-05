package id.co.nds.project.demo.entities;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {
  @Id
  @GenericGenerator(name = "cust_id_seq", strategy = "id.co.nds.project.demo.generators.CustomerIdGenerator")
  @GeneratedValue(generator = "cust_id_seq")
  @Column(name = "id")
  private String id;

  @Column(name = "nama")
  private String nama;

  @Column(name = "ktp")
  private String ktp;

  @JoinColumn(name = "id_jenis_usaha", referencedColumnName = "id")
  @Column(name = "id_jenis_usaha")
  private Integer jenisUsaha;

  @Column(name = "hp")
  private String hp;

  @Column(name = "cust_status")
  private char status;

  @Column(name = "jenis_kelamin")
  private char jenisKelamin;

  @Column(name = "max_limit_pinjaman")
  private Double maxLimitPinjaman;

  @OneToMany(targetEntity = CicilanTetapEntity.class, mappedBy = "id_pelanggan")
  private List<CicilanTetapEntity> cicilanTetapEntities;

  @Column(name = "created_date")
  private Timestamp createdDate;

  @Column(name = "updated_date")
  private Timestamp updatedDate;

  @Column(name = "deleted_date")
  private Timestamp deletedDate;

  @Column(name = "creator_id")
  private Integer creatorId;

  @Column(name = "updater_id")
  private Integer updaterId;

  @Column(name = "deleter_id")
  private Integer deleterId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getKtp() {
    return ktp;
  }

  public void setKtp(String ktp) {
    this.ktp = ktp;
  }

  public List<CicilanTetapEntity> getCicilanTetapEntities() {
    return cicilanTetapEntities;
  }

  public void setCicilanTetapEntities(List<CicilanTetapEntity> cicilanTetapEntities) {
    this.cicilanTetapEntities = cicilanTetapEntities;
  }

  public String getHp() {
    return hp;
  }

  public void setHp(String hp) {
    this.hp = hp;
  }

  public char getStatus() {
    return status;
  }

  public void setStatus(char status) {
    this.status = status;
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

  public Timestamp getDeletedDate() {
    return deletedDate;
  }

  public void setDeletedDate(Timestamp deletedDate) {
    this.deletedDate = deletedDate;
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

  public Integer getDeleterId() {
    return deleterId;
  }

  public void setDeleterId(Integer deleterId) {
    this.deleterId = deleterId;
  }

  public char getJenisKelamin() {
    return jenisKelamin;
  }

  public void setJenisKelamin(char jenisKelamin) {
    this.jenisKelamin = jenisKelamin;
  }

  public Double getMaxLimitPinjaman() {
    return maxLimitPinjaman;
  }

  public void setMaxLimitPinjaman(Double maxLimitPinjaman) {
    this.maxLimitPinjaman = maxLimitPinjaman;
  }

  public Integer getJenisUsaha() {
    return jenisUsaha;
  }

  public void setJenisUsaha(Integer jenisUsaha) {
    this.jenisUsaha = jenisUsaha;
  }
}
