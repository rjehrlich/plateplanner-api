package com.plateplanner.api.repository;

import com.plateplanner.api.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepo extends JpaRepository<RecipeIngredient, Long> {
}
