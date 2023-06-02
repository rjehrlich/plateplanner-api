package com.plateplanner.api.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groceryLists")
public class GroceryList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Ingredient> ingredients;

    public GroceryList() {
    }

    public GroceryList(Long id, List<Ingredient> ingredients) {
        this.id = id;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
