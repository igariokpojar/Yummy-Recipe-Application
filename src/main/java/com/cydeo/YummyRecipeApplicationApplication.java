package com.cydeo;

import com.cydeo.config.AuthorConfig;
import com.cydeo.service.RecipeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class YummyRecipeApplicationApplication {

    public static void main(String[] args) {

        // create a container
       ApplicationContext container =  SpringApplication.run(YummyRecipeApplicationApplication.class, args);
        RecipeService recipeService = container.getBean(RecipeService.class); // get Bean and class
        recipeService.prepareRecipe();

        // add Author class
        AuthorConfig author = container.getBean(AuthorConfig.class);
        System.out.println("Here you are! Author information of the recipe");
        System.out.println("Name " + author.getName() + " Surname " + author.getSurname()
                + "\n" + "Phone Number "  + author.getPhone() + "\n" + "Social Media Links "
                + author.getSocialMedias() + "\n" + "Email " + author.getEmail());

    }

}
