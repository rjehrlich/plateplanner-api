package com.plateplanner.api.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient {

    /**
     * Combine @Id annotation with @ManyToOne and @JoinColumn to manage the
     * foreign key mappings for Recipe and Ingredient entities
     */
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Column
    private BigDecimal quantity;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Recipe recipe, Ingredient ingredient, BigDecimal quantity) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipe=" + recipe +
                ", ingredient=" + ingredient +
                ", quantity=" + quantity +
                '}';
    }
}
