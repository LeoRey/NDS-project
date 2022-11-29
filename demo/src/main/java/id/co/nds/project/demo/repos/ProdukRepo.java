package id.co.nds.project.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import id.co.nds.project.demo.entities.CicilanTetapEntity;

@Repository
public interface ProdukRepo
                extends JpaRepository<CicilanTetapEntity, Integer>, JpaSpecificationExecutor<CicilanTetapEntity> {

}
