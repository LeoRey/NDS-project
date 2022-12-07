package id.co.nds.project.demo.specs;

import org.springframework.data.jpa.domain.Specification;

import id.co.nds.project.demo.entities.CicilanTetapEntity;
import id.co.nds.project.demo.entities.CustomerEntity;
import id.co.nds.project.demo.models.CicilanTetapRequestModel;
import id.co.nds.project.demo.utils.validationUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CicilanTetapSpec implements Specification<CicilanTetapEntity> {
  private CicilanTetapRequestModel model;

  public CicilanTetapSpec(CicilanTetapRequestModel model) {
    super();
    this.model = model;
  }

  @Override
  public Predicate toPredicate(Root<CicilanTetapEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    Predicate p = criteriaBuilder.and();
    Predicate por = criteriaBuilder.or();

    Join<CicilanTetapEntity, CustomerEntity> rJoin = root.join("CicilanTetap");

    // no_transaksi criteria
    if (!validationUtil.isEmpty(model.getNoTransaksi())) {
      p.getExpressions().add(criteriaBuilder.equal(root.get("no_transaksi"), model.getNoTransaksi()));
    }

    // id_pelanggan criteria
    if (!validationUtil.isEmpty(model.getCustId())) {
      p.getExpressions().add(criteriaBuilder.equal(rJoin.get("id"), model.getCustId()));
    }

    // nama_pelanggan criteria
    if (!validationUtil.isEmpty(model.getCustName())) {
      p.getExpressions().add(criteriaBuilder.equal(rJoin.get("nama"), model.getCustName()));
    }

    // Tanggal cicilan start criteria
    if (!validationUtil.isEmpty(model.getCicDateBegin())) {
      p.getExpressions().add(criteriaBuilder.greaterThan(root.get("tgl_aktif_cicilan"), model.getCicDateBegin()));
    }

    // Tanggal cicilan end criteria
    if (!validationUtil.isEmpty(model.getCicDateEnd())) {
      p.getExpressions().add(criteriaBuilder.lessThan(root.get("tgl_aktif_cicilan"), model.getCicDateEnd()));
    }

    query.orderBy(criteriaBuilder.asc(root.get("no_transaksi")));
    if (!model.getSelectedNoCic().isEmpty()) {
      for (Integer cicTarget : model.getSelectedNoCic()) {
        por.getExpressions().add(criteriaBuilder.equal(root.get("cicilan_ke"), cicTarget));
      }
      return criteriaBuilder.and(p, por);
    } else {
      return p;
    }
  }
}
