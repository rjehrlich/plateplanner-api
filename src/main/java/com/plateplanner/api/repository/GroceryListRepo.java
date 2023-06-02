package com.plateplanner.api.repository;

import com.plateplanner.api.model.GroceryList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryListRepo extends JpaRepository<GroceryList, Long> {
}
