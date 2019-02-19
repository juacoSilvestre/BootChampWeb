package com.organization.bootchampweb.dao;

import com.organization.bootchampweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

// CRUD refers Create, Read, Update, Delete
@Repository
public interface UserRepository extends CrudRepository<User, Long>, JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    User findByEmail(String email);

    User findByUserName(String userName);

    boolean existsByEmail(String email);

    boolean existsByUserName(String email);

    void deleteById(Long id);

}
