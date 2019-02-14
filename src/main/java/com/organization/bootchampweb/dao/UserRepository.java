package com.organization.bootchampweb.dao;

import com.organization.bootchampweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

// CRUD refers Create, Read, Update, Delete
@Repository
public interface UserRepository extends CrudRepository<User, Integer>, JpaRepository<User, Integer> {

    User findById(Long id);

    User findByEmail(String email);

    User findByUserName(String useraName);

    boolean existsByEmail(String email);

    boolean existsByUserName(String email);

    void deleteById(Integer id);

}
