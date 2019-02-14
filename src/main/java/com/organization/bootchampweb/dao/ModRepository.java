package com.organization.bootchampweb.dao;


import com.organization.bootchampweb.model.Game;
import com.organization.bootchampweb.model.Mod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  ModRepository extends CrudRepository<Mod, Integer>, JpaRepository<Mod, Integer> {


}