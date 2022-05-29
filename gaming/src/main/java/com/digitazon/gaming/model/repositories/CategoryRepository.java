package com.digitazon.gaming.model.repositories;

import com.digitazon.gaming.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
