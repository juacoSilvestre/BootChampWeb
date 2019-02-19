package com.organization.bootchampweb.rest;

import com.organization.bootchampweb.dao.GameRepository;
import com.organization.bootchampweb.model.Game;
import com.organization.bootchampweb.service.VerifyExistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.io.IOException;


@RestController
@RequestMapping(path="/game")
public class GameController {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    VerifyExistence verifyExistence;
    @GetMapping(path = "/all")
    public @Valid @ResponseBody
    Iterable<Game> getAllGames() {
        return gameRepository.findAll();
    }
    @PostMapping("/addGame")
    public ResponseEntity createGame(@Valid @RequestBody Game game){
        try{verifyExistence.verifyByGameName(game);
        gameRepository.save(game);}
        catch(IOException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The Game name already exist");
        }
        return ResponseEntity.ok("Great! "+game.getName()+" game has been succesfully created");
    }
    @PutMapping(path="/modify")
    public @Valid @ResponseBody ResponseEntity modifyGame(@Valid @RequestBody Game game ) {
        try{
        verifyExistence.correctGameModify( game);
        gameRepository.save(game);}
        catch (IOException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The Game name cannot be changed");
        }
        return ResponseEntity.ok("Great! "+game.getName()+" game has been succesfully updated");
    }
    @DeleteMapping("/deleteById")
    public @Valid @ResponseBody ResponseEntity deleteById(@RequestParam Integer id){
        gameRepository.deleteById(id);
        return ResponseEntity.ok("the game has been succesfully deleted");
    }

    @GetMapping(path = "/getById")
    public @ResponseBody Game getById(@RequestParam Long id){
        return gameRepository.findById(id);
    }
    @GetMapping(path = "/getByName")
    public @ResponseBody Game getByName(@RequestParam String name){
        return gameRepository.findByName(name);
    }
}
