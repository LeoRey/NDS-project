package id.co.nds.project.demo.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class CustomerEntity {
  @Id
  @Column(name = "customer_id")
  private String customerId;

  @Column(name = "customer_name")
  private String name;

  @Column(name = "ktp")
  private String ktp;

  @OneToMany(targetEntity = CicilanTetapEntity.class, mappedBy = "id_pelanggan")
  private List<CicilanTetapEntity> cicilanTetapEntities;

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
}
