package com.plateplanner.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient implements Serializable {

    /**
     * the composite primary key
     */
    @EmbeddedId
    private RecipeIngredientId id;

    /**
     * Combine @Id annotation with @ManyToOne and @JoinColumn to manage the
     * foreign key mappings for Recipe and Ingredient entities
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_id")
    @MapsId("recipeId") // Maps to the recipe field in RecipeIngredientId
    private Recipe recipe;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ingredient_id")
    @MapsId("ingredientId") // Maps to the ingredient field in RecipeIngredientId
    private Ingredient ingredient;

    @Transient
    private String ingredientName;

    @Column
    private String quantity;

    public RecipeIngredient() {
    }


    public RecipeIngredient(Recipe recipe, Ingredient ingredient, String quantity) {
        this.id = new RecipeIngredientId(recipe.getId(), ingredient.getId());
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    /**
     * hashCode method overrides the default method in the superclass
     * @return a hash code of object calculating composite key values
     */
    @Override
    public int hashCode() {
        return Objects.hash(recipe, ingredient);
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

        // // compare recipe/ingredient attribute of object with recipe/ingredient attribute of obj(that)
        return Objects.equals(recipe, that.recipe) && Objects.equals(ingredient, that.ingredient);
    }


    public RecipeIngredientId getId() {
        return id;
    }

    public void setId(RecipeIngredientId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "id=" + id +
                ", recipe=" + recipe +
                ", ingredient=" + ingredient +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
