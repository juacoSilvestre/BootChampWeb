package com.organization.bootchampweb.dao;


import com.organization.bootchampweb.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {

    boolean existsByName(String name);
    Game findByName(String name);
    Game findById(Long id);
}