package com.cydeo.repository;

import com.cydeo.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
// Create a Class that is going to Implement the Interface method
public class RecipeRepositoryImpl  implements RecipeRepository{

List<Recipe> recipeList = new ArrayList<>();
    @Override
    public boolean save(Recipe recipe) {
        recipeList.add(recipe);
        return false;
    }
}
