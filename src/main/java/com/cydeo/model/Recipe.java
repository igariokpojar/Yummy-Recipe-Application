package com.cydeo.model;

import com.cydeo.enums.RecipeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
public class Recipe {

    private UUID recipeId;
    private String name;
    private int duration;
    private String preparation;
    private List<Ingredient> ingredientList;
    private RecipeType recipeType;
}
