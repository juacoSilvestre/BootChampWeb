package com.organization.bootchampweb.dao;



import com.organization.bootchampweb.model.Mod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface  ModRepository extends CrudRepository<Mod, Long>, JpaRepository<Mod, Long> {

    Optional<Mod> findById(Long id);
    List<Mod> findByName(String name);
}