package com.fcalazans.drinksmenumanagement.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.fcalazans.drinksmenumanagement.database.DrinksDatabase;
import com.fcalazans.drinksmenumanagement.database.dao.RecipeDao;
import com.fcalazans.drinksmenumanagement.database.entities.Recipe;

import java.util.List;

public class RecipeRepository {
    private final RecipeDao recipeDao;
    private final LiveData<List<Recipe>> allRecipes;

    public RecipeRepository(Application application) {
        DrinksDatabase drinksDatabase = DrinksDatabase.getInstance(application);
        recipeDao = drinksDatabase.recipeDao();
        allRecipes = recipeDao.getAllRecipes();

    }

    public LiveData<List<Recipe>> getAllRecipes() {
        return allRecipes;
    }


    public void insert(Recipe recipe) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> recipeDao.insertRecipe(recipe));
    }

    public void update(Recipe recipe) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> recipeDao.updateRecipe(recipe));
    }

    public void delete(Recipe recipe) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> recipeDao.deleteRecipe(recipe));
    }

}
