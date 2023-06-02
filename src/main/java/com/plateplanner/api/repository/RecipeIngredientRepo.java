package com.plateplanner.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepo extends JpaRepository<RecipeIngredientRepo, Long> {
}
