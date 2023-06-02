package com.plateplanner.api.repository;

import com.plateplanner.api.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeIngredientRepo extends JpaRepository<RecipeIngredient, Long> {

    List<RecipeIngredient> findAllByRecipeId(Long recipeId);

    Optional<RecipeIngredient> findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
