package com.organization.bootchampweb.dao;

import com.organization.bootchampweb.model.UserItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<UserItem, Integer> {

   UserItem findById(Long id);

   void deleteById(Long id);
}