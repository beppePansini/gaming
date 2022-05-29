package com.digitazon.gaming.controllers;

import com.digitazon.gaming.model.entities.Category;
import com.digitazon.gaming.model.entities.Creator;
import com.digitazon.gaming.model.entities.Game;
import com.digitazon.gaming.model.repositories.CategoryRepository;
import com.digitazon.gaming.model.repositories.CreatorRepository;
import com.digitazon.gaming.model.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "*")
public class GameController {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CreatorRepository creatorRepository;

    public GameController(GameRepository gameRepository, CategoryRepository categoryRepository,
                          CreatorRepository creatorRepository) {
        this.gameRepository = gameRepository;
        this.categoryRepository = categoryRepository;
        this.creatorRepository = creatorRepository;
    }

    @PostMapping("/add")
    public Game insertGame(@RequestBody Game newGame) {
        Game savedGame = gameRepository.save(newGame);
        Category category = categoryRepository.findById(savedGame.getCategory().getId()).orElseThrow();
        Creator creator = creatorRepository.findById(savedGame.getCreator().getId()).orElseThrow();
        newGame.setCategory(category);
        newGame.setCreator(creator);
        return newGame;
    }

    @GetMapping
    public ResponseEntity findGame(@RequestParam(required = false) String name,@RequestParam(required = false) Integer categoryId ) {
        if ((name != null && !name.equals("")) && categoryId != null) {
            System.out.println("ricerca per i parametri");
            return ResponseEntity.ok(gameRepository.findByNameLikeAndCategoryId(name, categoryId));
        } else if ((name == null || name.equals("")) && categoryId != null) {
            return ResponseEntity.ok(gameRepository.findByCategoryId(categoryId));
        } else if ((name != null && !name.equals("")) && categoryId == null) {
            return ResponseEntity.ok(gameRepository.findByNameLike(name.toLowerCase()));
        } else {
            return ResponseEntity.ok(gameRepository.findAllByOrderByNameAsc());
        }
    }

    @PutMapping
    public List<Game> updateGameById(@RequestBody Game updatedGame) {
        Game game = gameRepository.findById(updatedGame.getId()).orElseThrow();
        game.setName(updatedGame.getName());
        game.setDescription(updatedGame.getDescription());
        game.setPrice(updatedGame.getPrice());
        game.setCategory(updatedGame.getCategory());
        game.setCreator(updatedGame.getCreator());
        game.setPsVersion(updatedGame.isPsVersion());
        game.setXboxVersion(updatedGame.isXboxVersion());
        game.setPcVersion(updatedGame.isPcVersion());
        game.setPhoneVersion(game.isPhoneVersion());
        game.setImg(updatedGame.getImg());
        gameRepository.save(game);
        return gameRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteGame(@PathVariable int id) {
        gameRepository.deleteById(id);
        return "ok";
    }
}
