package com.organization.bootchampweb.service;

import com.organization.bootchampweb.dao.GameRepository;
import com.organization.bootchampweb.dao.ModRepository;
import com.organization.bootchampweb.dao.UserRepository;
import com.organization.bootchampweb.model.Game;
import com.organization.bootchampweb.model.Mod;
import com.organization.bootchampweb.model.User;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.util.Optional;


@Repository
public class VerifyExistence {

    public void verifyByEmail(UserRepository userRepository,@Valid User user){
    if(userRepository.existsByEmail(user.getEmail())){
        throw new RuntimeException("The email already exist");}
    }

    public void verifyByUserName( UserRepository userRepository,@Valid User user){
        if(userRepository.existsByUserName(user.getUserName())){
        throw new RuntimeException("The Username already exist");}
    }
    public void verifyByGameName(GameRepository gameRepository , Game game){
        if(gameRepository.existsByName(game.getName())){
            throw new RuntimeException("The Game name already exist");
        }
    }

    public void correctUserModifyUserName( UserRepository userRepository,@Valid User user){
        User userVerification=userRepository.findByEmail(user.getEmail());
        if(!userVerification.getUserName().equals(user.getUserName())){
                throw new RuntimeException("The Username cannot be changed");
            }
        }
    /*public void MethodValidationPostProcessor( UserRepository userRepository,@Valid User user){
        User userVerification=userRepository.findByEmail(user.getEmail());
        if(!userVerification.getUserName().equals(user.getUserName())){
                throw new RuntimeException("The Username cannot be changed");
            }
        }*/
    public void correctUserModifyEmail( UserRepository userRepository,@Valid User user){
        User userVerification=userRepository.findByEmail(user.getEmail());
        if(!userVerification.getEmail().equals(user.getEmail())){
                throw new RuntimeException("The Email addres cannot be changed");
            }
        }
    /*public void VerifyByModName(ModRepository modRepository, @Valid Mod mod){
        if(modRepository.existsById(mod.getId());
    }*/
}


