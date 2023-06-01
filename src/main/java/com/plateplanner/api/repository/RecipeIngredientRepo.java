package com.plateplanner.api.repository;

import com.plateplanner.api.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientRepo extends JpaRepository<RecipeIngredient, Long> {
}
