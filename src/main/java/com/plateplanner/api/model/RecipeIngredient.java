package com.plateplanner.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient implements Serializable {

    /**
     * Combine @Id annotation with @ManyToOne and @JoinColumn to manage the
     * foreign key mappings for Recipe and Ingredient entities
     */
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    public Recipe recipe;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    public Ingredient ingredient;

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

    /**
     * hashCode method overrides the default method in the superclass
     * if the recipe attribute is not null, use hashCode method to calculate the hashCode, else result is 0
     * then, combine the hash code of recipe with the hash code of ingredient using 31 as a prime number
     * @return an integer representing hash code of this object
     */
    @Override
    public int hashCode() {
        int result = recipe != null ? recipe.hashCode() : 0;
        result = 31 * result + (ingredient != null ? ingredient.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
