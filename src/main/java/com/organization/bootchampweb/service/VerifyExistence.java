package com.organization.bootchampweb.service;

import com.organization.bootchampweb.dao.GameRepository;
import com.organization.bootchampweb.dao.ModRepository;
import com.organization.bootchampweb.dao.TransactionRepository;
import com.organization.bootchampweb.dao.UserRepository;
import com.organization.bootchampweb.model.Game;
import com.organization.bootchampweb.model.Mod;
import com.organization.bootchampweb.model.User;
import com.organization.bootchampweb.model.UserItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;


@Repository
public class VerifyExistence {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    GameRepository gameRepository;

    public void verifyByEmail(@Valid User user) throws RuntimeException{
    if(userRepository.existsByEmail(user.getEmail())){
        throw new RuntimeException("The email already exist");}
    }

    public void verifyByUserName(@Valid User user) throws IOException {
        if(userRepository.existsByUserName(user.getUserName())){
        throw new IOException("The Username already exist");}
    }
    public void verifyByGameName(Game game) throws IOException {
        if(gameRepository.existsByName(game.getName())){
            throw new IOException("The Game name already exist");
        }
    }

    public void correctUserModifyUserName( @Valid User user) throws RuntimeException{
        User userVerification=userRepository.findByEmail(user.getEmail());
        if(!userVerification.getUserName().equals(user.getUserName())){
                throw new RuntimeException("The Username cannot be changed");
            }
        }

    public void correctUserModifyEmail(@Valid User user) throws IOException {
        User userVerification=userRepository.findByEmail(user.getEmail());
        if(!userVerification.getEmail().equals(user.getEmail())){
                throw new IOException("The Email addres cannot be changed");
            }
        }
    public void correctGameModify(@Valid Game game) throws IOException {
        Game gameVerification=gameRepository.findByName(game.getName());
        if(!gameVerification.getName().equals(game.getName())){
            throw new IOException("The Game name cannot be changed");
        }
    }


}


