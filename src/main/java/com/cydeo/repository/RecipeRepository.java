package com.cydeo.repository;

import com.cydeo.model.Recipe;
import org.springframework.stereotype.Component;


public interface RecipeRepository {

    boolean save(Recipe recipe);
}
