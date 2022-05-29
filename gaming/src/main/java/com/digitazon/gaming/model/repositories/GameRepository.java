package com.digitazon.gaming.model.repositories;

import com.digitazon.gaming.model.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findAllByOrderByNameAsc();
    @Query("select g from Game g where lower(g.name) like %:name%")
    List<Game> findByNameLike(String name);
    List<Game> findByCategoryId(Integer id);
    @Query("select g from Game g where lower(g.name) like %:name% and category.id= :categoryId")
    List<Game> findByNameLikeAndCategoryId(String name, Integer categoryId);
}
