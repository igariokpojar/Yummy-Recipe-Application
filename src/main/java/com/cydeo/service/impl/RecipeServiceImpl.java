package com.cydeo.service.impl;

import com.cydeo.enums.QuantityType;
import com.cydeo.enums.RecipeType;
import com.cydeo.model.Ingredient;
import com.cydeo.model.Recipe;
import com.cydeo.repository.RecipeRepository;
import com.cydeo.service.RecipeService;
import com.cydeo.service.ShareService;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.*;

// I create a class to Implement RecipeService Interface
@Component
public class RecipeServiceImpl implements RecipeService {

   private final RecipeRepository recipeRepository; // I injected two Interfaces inside the class by Requirements
   private final ShareService shareService;
   private final Faker faker; // JavaFaker is a field to create Recipe Objects

    public RecipeServiceImpl(RecipeRepository recipeRepository, ShareService shareService, Faker faker) {
        this.recipeRepository = recipeRepository;
        this.shareService = shareService;
        this.faker = faker;
    }


    @Override
    public boolean prepareRecipe() {
        // using loop we create Recipe for each Recipe Type for example 20 recipe for each type value
        for (int i = 0; i <20 ; i++) {

            Arrays.stream(RecipeType.values()).forEach(recipeType -> {
        // Create Recipe Objects
        Recipe recipe = new Recipe();
        recipe.setRecipeId(UUID.randomUUID());
        recipe.setName(faker.food().dish());
        recipe.setDuration(generateRandomValue());
        recipe.setPreparation(faker.lorem().paragraph(generateRandomValue()));
        recipe.setIngredientList(prepareIngredients());
        recipe.setRecipeType(recipeType);
        // save and share recipe inside of repository
        recipeRepository.save(recipe);
        shareService.share(recipe);
            });
        }
        return true;
    }
    /*     Second way to Prepare recipe
    public void prepare(Recipe recipe) {
        Faker faker= new Faker();
        List<Ingredients> ingredientsList= new ArrayList<>();

        int i=0;
        while(i<8){
            Ingredients ingredients= new Ingredients();

            ingredients.setName(faker.food().ingredient());
            ingredients.setQuantity(faker.number().randomDigit());
            ingredients.setQuantityType(QuantityType.getQuantityType(faker.number().numberBetween(1,3)));
            ingredientsList.add(ingredients);

            i++;}

        recipe.setIngredientsList(ingredientsList);
        recipeRepository.save(recipe);
        shareService.share(recipe);
 }
 */

      // create  a method that is going to return objects
    private List<Ingredient> prepareIngredients() {
        List<QuantityType> quantityTypeList = List.of(QuantityType.values());
        List<Ingredient> ingredientList = new ArrayList<>();
        // add all the ingredients Objects inside the ingredientList be using loop
        for (int i = 0; i < generateRandomValue(); i++) {
            Ingredient ingredient = new Ingredient(); // create new Object
            ingredient.setName(faker.food().ingredient());
            ingredient.setQuantity(generateRandomValue());
            ingredient.setQuantityType(quantityTypeList.get(new Random().nextInt(3)));
            ingredientList.add(ingredient);
        }
        return ingredientList;
    }

    // create a method that is going to generate Randomly number
    private int generateRandomValue(){  //  private access modifier  is use for never call outside this class
        return new Random().nextInt(20);
    }


}
