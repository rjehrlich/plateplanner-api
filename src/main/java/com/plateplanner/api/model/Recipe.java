package com.plateplanner.api.model;

public class Recipe {
    private Long id;
    private String title;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private String instructions;

    public Recipe() {
    }

    public Recipe(Long id, String title, String description, Integer prepTime, Integer cookTime, String instructions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.instructions = instructions;
    }
}
