package com.fcalazans.drinksmenumanagement.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.fcalazans.drinksmenumanagement.database.entities.Ingredient;

import java.util.List;

@Dao
public interface IngredientDao {

    @Query("SELECT * FROM ingredient ORDER BY ingredient_name ASC")
    LiveData<List<Ingredient>> getAllIngredients();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertIngredient(Ingredient ingredient);

    @Update
    void updateIngredient(Ingredient ingredient);

    @Delete
    void deleteIngredient(Ingredient ingredient);

//    @Transaction
//    @Query("SELECT * FROM Category")
//    LiveData<List<EventWithMenu>> getEventWithMenu();
//
//    @Transaction
//    @Query("SELECT * FROM Menu")
//    LiveData<List<MenuWithEvent>> getMenuWithEvent();

}