package id.co.nds.project.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.nds.project.demo.entities.JenisUsahaEntity;

@Repository
public interface JenisUsahaRepo
                extends JpaRepository<JenisUsahaEntity, String> {

}
