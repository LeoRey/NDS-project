package id.co.nds.project.demo.specs;

import org.springframework.data.jpa.domain.Specification;

import id.co.nds.project.demo.entities.CustomerEntity;
import id.co.nds.project.demo.models.CustomerModel;
import id.co.nds.project.demo.utils.validationUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CustomerSpec implements Specification<CustomerEntity> {
  private CustomerModel model;

  public CustomerSpec(CustomerModel model) {
    super();
    this.model = model;
  }

  @Override
  public Predicate toPredicate(Root<CustomerEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    Predicate p = criteriaBuilder.and();

    if (!validationUtil.isEmpty(model.getCustId())) {
      p.getExpressions().add(criteriaBuilder.equal(root.get("id"), model.getCustId()));
    }

    if (!validationUtil.isEmpty(model.getCustName())) {
      p.getExpressions().add(criteriaBuilder.equal(root.get("nama"), model.getCustName()));
    }

    if (!validationUtil.isEmpty(model.getCustKtp())) {
      p.getExpressions().add(criteriaBuilder.equal(root.get("ktp"), model.getCustKtp()));
    }

    if (!validationUtil.isEmpty(model.getCustHp())) {
      p.getExpressions().add(criteriaBuilder.equal(root.get("hp"), model.getCustHp()));
    }

    if (!validationUtil.isEmpty(model.getCustJenisUsahaId())) {
      p.getExpressions().add(criteriaBuilder.equal(root.get("jenis_usaha"), model.getCustJenisUsahaId()));
    }

    if (!(validationUtil.isEmpty(model.getCustStatus().trim()))) {
      p.getExpressions().add(criteriaBuilder.equal(root.get("cust_status"), model.getCustStatus()));
    }

    query.orderBy(criteriaBuilder.asc(root.get("id")));
    return p;
  }
}
