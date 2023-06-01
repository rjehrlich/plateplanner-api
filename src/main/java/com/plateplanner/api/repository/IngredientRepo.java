package com.plateplanner.api.repository;

import com.plateplanner.api.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepo extends JpaRepository<Ingredient, Long> {
}
