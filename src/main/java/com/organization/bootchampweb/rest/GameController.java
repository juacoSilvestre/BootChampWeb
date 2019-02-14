package com.organization.bootchampweb.rest;

import com.organization.bootchampweb.dao.GameRepository;
import com.organization.bootchampweb.model.Game;
import com.organization.bootchampweb.service.VerifyExistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;


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
        // This returns a JSON or XML with the users
        return gameRepository.findAll();
    }
    @PostMapping("/addGame")
    public Game createGame(@Valid @RequestBody Game game){
        //verifyExistence.verifyByGameName(gameRepository, game);
        return gameRepository.save(game);
    }
    @PutMapping(path="/modify")
    public @Valid @ResponseBody Game modifyGame(@Valid @RequestBody Game game ) {

        return gameRepository.save(game);
    }
    @DeleteMapping("/deleteById")
    public @Valid @ResponseBody void deleteById(@RequestParam Integer id){
        gameRepository.deleteById(id);
    }
}
