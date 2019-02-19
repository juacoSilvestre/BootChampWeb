package com.organization.bootchampweb.rest;

import com.organization.bootchampweb.dao.UserRepository;
import com.organization.bootchampweb.model.User;
import com.organization.bootchampweb.model.UserItem;
import com.organization.bootchampweb.service.SecurePassword;
import com.organization.bootchampweb.service.UserMessage;
import com.organization.bootchampweb.service.VerifyExistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;

@RestControllerAdvice
@RestController    // This means that this class is a Controller
@RequestMapping(path = "/user") // This means URL's start with /demo (after Application path)
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SecurePassword securePassword;
    @Autowired
    VerifyExistence verifyExistence;
    @Autowired
    UserMessage userMessage;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/getById")
    public @ResponseBody
    Optional<User> getById(@RequestParam Long id) {
        return userRepository.findById(id);
    }

    @GetMapping(path = "/getByEmail")
    public @ResponseBody
    ResponseEntity getByEmail(@RequestParam String email)
    {
        User user = userRepository.findByEmail(email);
        return ResponseEntity.ok(userMessage.showUser(user));
    }

    @GetMapping(path = "/getByUserName")
    public @ResponseBody
    ResponseEntity<String> getByUserName(@RequestParam String userName) {
        User user = userRepository.findByUserName(userName);
        return new ResponseEntity(userMessage.showUser(user), HttpStatus.OK);
    }


    @PostMapping("/addUser")
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        try {
            verifyExistence.verifyByEmail(user);
            verifyExistence.verifyByUserName(user);
            String newPass = securePassword.securePassword(user.getPassword(), "Base64");
            user.setPassword(newPass);
            userRepository.save(user);}

            catch (IOException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The UserName already exist");
            }
         catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The email already exist");
        }
        ;
        return ResponseEntity.ok("Welcome "+user.getUserName()+" your user has been succesfully created");
    }

    @DeleteMapping("/deleteById")
    public @ResponseBody
    ResponseEntity deleteById(@RequestParam Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok("Great! the user has been succesfully deleted");
    }


    @PutMapping(path = "/modify")
    public @ResponseBody
    ResponseEntity modifyUser(@Valid @RequestBody User user) {
        try{
        verifyExistence.correctUserModifyUserName(user);
        verifyExistence.correctUserModifyEmail(user);
        String newPass = securePassword.securePassword(user.getPassword(), "Base64");
        user.setPassword(newPass);
        userRepository.save(user);}
        catch (IOException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The Email addres cannot be changed");
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The Username cannot be changed");
        }
        return ResponseEntity.ok("Great! "+user.getUserName()+" your user has been succesfully Updated");
    }

}