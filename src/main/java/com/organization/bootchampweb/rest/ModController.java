package com.organization.bootchampweb.rest;

import com.organization.bootchampweb.dao.ModRepository;
import com.organization.bootchampweb.model.Game;
import com.organization.bootchampweb.model.Mod;
import com.organization.bootchampweb.service.VerifyExistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        //verifyExistence.verifyByGameName(modRepository, mod);
        return modRepository.save(mod);
    }
    @PutMapping(path="/modify")
    public @Valid @ResponseBody Mod modifyMod(@Valid @RequestBody Mod mod ) {

        return modRepository.save(mod);
    }
    @DeleteMapping("/deleteById")
    public @Valid @ResponseBody void deleteById(@RequestParam Integer id){
        modRepository.deleteById(id);
    }



}


