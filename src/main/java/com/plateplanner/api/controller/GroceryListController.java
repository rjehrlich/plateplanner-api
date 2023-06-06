package com.plateplanner.api.controller;

import com.plateplanner.api.model.GroceryList;
import com.plateplanner.api.service.GroceryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroceryListController {

    private GroceryListService groceryListService;

    @Autowired
    public void setGroceryListService(GroceryListService groceryListService) {
        this.groceryListService = groceryListService;
    }

    /**
     * generateGroceryList method creates an endpoint mapping that takes in multiple:
     * @param recipeIds and
     * @return all ingredients in a list for ALL recipes
     */
    @PostMapping("/grocery-lists")
    public GroceryList generateGroceryList(@RequestBody List<Long> recipeIds) {
        return groceryListService.generateGroceryList(recipeIds);
    }

}
