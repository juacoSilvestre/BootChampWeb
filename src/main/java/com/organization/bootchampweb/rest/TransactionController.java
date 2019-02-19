package com.organization.bootchampweb.rest;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.organization.bootchampweb.dao.GameRepository;
import com.organization.bootchampweb.dao.TransactionRepository;
import com.organization.bootchampweb.dao.UserRepository;
import com.organization.bootchampweb.model.Game;
import com.organization.bootchampweb.model.User;
import com.organization.bootchampweb.model.UserItem;
import com.organization.bootchampweb.service.VerifyExistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

//@Transactional//(propagation= Propagation.REQUIRED)
@RestController
@RequestMapping(path="/transaction")
public class TransactionController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserController userController;
    @Autowired
    GameController gameController;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    VerifyExistence verifyExistence;

    @GetMapping(path = "/all")
    public @Valid @ResponseBody Iterable<UserItem> getAlltransactions() {
        return transactionRepository.findAll();
    }


    @PostMapping("/addTransaction")
    public ResponseEntity createTransaction(@Valid @RequestBody  UserItem transaction){
        try{
            transactionRepository.save(transaction);
            return ResponseEntity.ok("the transaction has been saved");
            //ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The transaction has been done");
        }catch (RuntimeException e){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The transaction cannot be done");
        }

    }
    @PutMapping(path="/modify")
    public @Valid @ResponseBody ResponseEntity modifyTransaction(@Valid @RequestBody UserItem transaction ) {
        try{
            //transaction.getUsers().setUserItems((Set<UserItem>) transaction);
            //transaction.getGames().setUserItems((Set<UserItem>) transaction);
            transactionRepository.save(transaction);
            //ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The transaction has been done");
        }catch (RuntimeException e){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The transaction cannot be done");
        }
        return ResponseEntity.ok("the transaction has been correctly modified");

    }

    @DeleteMapping("/deleteById")
    public @Valid @ResponseBody ResponseEntity deleteById(@RequestParam Long id){
        transactionRepository.deleteById(id);
        return ResponseEntity.ok("the transaction has been correctly deleted");
    }

    @GetMapping(path = "/getById")
    public @ResponseBody UserItem getById(@RequestParam Long id){
        return transactionRepository.findById(id);
    }

}