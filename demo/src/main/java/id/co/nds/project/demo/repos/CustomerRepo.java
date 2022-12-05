package id.co.nds.project.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.project.demo.entities.CustomerEntity;

@Repository
public interface CustomerRepo
                extends JpaRepository<CustomerEntity, String>, JpaSpecificationExecutor<CustomerEntity> {
        @Query(value = "SELECT COUNT(*) FROM user WHERE cust_status ='A'"
                        + " AND hp=':num'", nativeQuery = true)
        long countByCallNumber(@Param("num") String hp);

        @Query(value = "SELECT COUNT(*) FROM user WHERE cust_status ='A'"
                        + " AND hp=':num' AND id != ':id'", nativeQuery = true)
        long countByCallNumber(@Param("num") String hp, @Param("id") String id);

        @Query(value = "SELECT COUNT(*) FROM user WHERE cust_status ='A'"
                        + " AND ktp=':ktp'", nativeQuery = true)
        long countByKTP(@Param("ktp") String ktp);

        @Query(value = "SELECT COUNT(*) FROM user WHERE cust_status ='A'"
                        + " AND ktp=':ktp' AND id != ':id'", nativeQuery = true)
        long countByKTP(@Param("ktp") String ktp, @Param("id") String id);

}
