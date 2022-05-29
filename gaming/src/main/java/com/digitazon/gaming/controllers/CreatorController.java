package com.digitazon.gaming.controllers;

import com.digitazon.gaming.model.entities.Creator;
import com.digitazon.gaming.model.repositories.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/creator")
@CrossOrigin(origins = "*")
public class CreatorController {

    @Autowired
    CreatorRepository creatorRepository;

    public CreatorController(CreatorRepository creatorRepository) {
        this.creatorRepository = creatorRepository;
    }

    @GetMapping
    public List<Creator> findAllCreator() {
        return creatorRepository.findAll();
    }
}
