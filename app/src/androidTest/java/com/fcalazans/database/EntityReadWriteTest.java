package com.fcalazans.database;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.fcalazans.drinksmenumanagement.database.DrinksDatabase;
import com.fcalazans.drinksmenumanagement.database.dao.RecipeDao;
import com.fcalazans.drinksmenumanagement.database.entities.Recipe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(AndroidJUnit4.class)
public class EntityReadWriteTest {
    private RecipeDao recipeDao;
    private DrinksDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, DrinksDatabase.class).build();
        recipeDao = db.recipeDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void insertRecipe() throws Exception {

        Recipe recipe = new Recipe();
        recipe.recipeName = "TestDrink";
        recipeDao.insertRecipe(recipe);
    }

}