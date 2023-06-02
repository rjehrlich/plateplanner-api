package com.plateplanner.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "recipe_ingredient")
@IdClass(RecipeIngredientId.class)
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
     * @return an integer representing hash code of this object
     */
    @Override
    public int hashCode() {
        // if the recipe attribute is not null
            // use hashCode method to calculate the hashCode, else result is 0
        int result = recipe != null ? recipe.hashCode() : 0;

        //combine the hash code of recipe with the hash code of ingredient using 31 as a prime number
        result = 31 * result + (ingredient != null ? ingredient.hashCode() : 0);
        return result;
    }

    /**
     * equals method overrides the default method in the Object's class. It takes a:
     * @param obj and
     * @return a boolean indicating if the current object is equal to the given one
     */
    @Override
    public boolean equals(Object obj) {
        // if obj is same instance of current object (this) in memory
            // they are equal and return true
        if (this == obj) return true;

        // if obj is null or does not belong to this class,
            // then they are not equal, so return false
        if (obj == null || getClass() != obj.getClass()) return false;

        // cast obj to the RecipeIngredient class so attributes can be compared
        RecipeIngredient that = (RecipeIngredient) obj;

        // compare recipe attribute of object with recipe attribute of obj(that)
        if (!Objects.equals(recipe, that.recipe)) return false;

        // // compare ingredient attribute of object with ingredient attribute of obj(that)
        return Objects.equals(ingredient, that.ingredient);
    }
}
