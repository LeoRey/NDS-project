package id.co.nds.project.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.project.demo.entities.CicilanTetapEntity;
import id.co.nds.project.demo.models.CicilanTetapRequestModel;

@Repository
public interface CicilanTetapRepo
        extends JpaRepository<CicilanTetapEntity, Integer>, JpaSpecificationExecutor<CicilanTetapEntity> {

    @Query(value = "SELECT ct.*, c.customer_name AS namaPelanggan, c.ktp AS noKTP FROM CicilanTetap ct "
            + "JOIN Customer c ON c.customer_id = ct.id_pelanggan WHERE (ct.no_transaksi= " +
            ":#{criteria.getNoTransaksi()} or :#{criteria.getNoTransaksi()} is null or :#{criteria.getNoTransaksi()} = '') "
            +
            "AND (ct.id_pelanggan= " +
            ":#{criteria.getCustId()} or :#{criteria.getCustId()} is null or :#{criteria.getCustId()} = '') "
            +
            "AND (c.customer_name= " +
            ":#{criteria.getCustName()} or :#{criteria.getCustName()} is null or :#{criteria.getCustName()} = '') "
            +
            "AND (ct.tgl_cicilan_start= " +
            ":#{criteria.getCicDateBegin()} or :#{criteria.getCicDateBegin()} is null or :#{criteria.getCicDateBegin()} = '') "
            +
            "AND (ct.tgl_cicilan_end= " +
            ":#{criteria.getCicDateEnd()} or :#{criteria.getCicDateEnd()} is null or :#{criteria.getCicDateEnd()} = '') ", nativeQuery = true)
    List<CicilanTetapEntity> FindPembayaranCicilanTetap(@Param("criteria") CicilanTetapRequestModel criteria);

}
