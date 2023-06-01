package com.plateplanner.api.model;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class RecipeTest {

    Recipe recipe;

    @BeforeEach
    public void setUp() {
        recipe = new Recipe();
    }

    @Test
    @DisplayName("when new recipe is created before seed data, recipe id is null")
    public final void whenNewRecipeCreated() {
        Assert.assertEquals(recipe.getId(), null);
    }
}