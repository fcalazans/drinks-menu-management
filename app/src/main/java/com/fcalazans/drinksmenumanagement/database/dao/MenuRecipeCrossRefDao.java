package com.fcalazans.drinksmenumanagement.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.fcalazans.drinksmenumanagement.database.entities.MenuRecipeCrossRef;
import com.fcalazans.drinksmenumanagement.database.relations.MenuWithRecipe;
import com.fcalazans.drinksmenumanagement.database.relations.RecipeWithMenu;

import java.util.List;

@Dao
public interface MenuRecipeCrossRefDao {

    @Query("SELECT * FROM menu_recipe")
    LiveData<List<MenuRecipeCrossRef>> getAllMenuRecipeCrossRef();


    @Transaction
    @Query("SELECT * FROM Recipe")
    LiveData<List<RecipeWithMenu>> getRecipeWithMenu();

    @Transaction
    @Query("SELECT * FROM Menu")
    LiveData<List<MenuWithRecipe>> getMenuWithRecipe();

}