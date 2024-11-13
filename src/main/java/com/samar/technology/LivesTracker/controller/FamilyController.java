package com.samar.technology.LivesTracker.controller;

import com.samar.technology.LivesTracker.model.Family;
import com.samar.technology.LivesTracker.service.FamilyService;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apis/v1/family")
public class FamilyController{

    @Autowired
    FamilyService familyService;
    @GetMapping(produces = MediaType.APPLICATION_XML)
    public List<Family> getFamilies(){
        return familyService.getAllFamily();
    }

    @PostMapping
    public ResponseEntity<Family> addFamily(@RequestBody Family family){
        Family savedFamily = familyService.addFamily(family);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFamily);
    }

}
