package com.plateplanner.api.repository;

import com.plateplanner.api.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {
}
