package com.organization.bootchampweb.rest;

import com.organization.bootchampweb.dao.ModRepository;
import com.organization.bootchampweb.model.Mod;
import com.organization.bootchampweb.service.VerifyExistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping(path="/mod")
public class ModController {
    @Autowired
    ModRepository modRepository;

    @Autowired
    VerifyExistence verifyExistence;

    @GetMapping(path = "/all")
    public @Valid
    @ResponseBody
    Iterable<Mod> getAllMod() {
        return modRepository.findAll();
    }

    @PostMapping("/addMod")
    public Mod createMod(@Valid @RequestBody Mod mod){
        return modRepository.save(mod);
    }
    @PutMapping(path="/modify")
    public @Valid @ResponseBody Mod modifyMod(@Valid @RequestBody Mod mod ) {

        return modRepository.save(mod);
    }
    @DeleteMapping("/deleteById")
    public @Valid @ResponseBody ResponseEntity deleteById(@RequestParam Long id){
        modRepository.deleteById(id);
        return ResponseEntity.ok("Great! the mod has been succesfully deleted");
    }

    @GetMapping(path = "/getById")
    public @ResponseBody
    Optional<Mod> getById(@RequestParam Long id){
        return modRepository.findById(id);
    }
    @GetMapping(path = "/getByName")
    public @ResponseBody Mod getByName(@RequestParam String name){

        return (Mod) modRepository.findByName(name);
    }



}


