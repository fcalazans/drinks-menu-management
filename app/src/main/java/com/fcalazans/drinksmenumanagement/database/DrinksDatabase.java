package com.fcalazans.drinksmenumanagement.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.fcalazans.drinksmenumanagement.database.entities.Event;
import com.fcalazans.drinksmenumanagement.database.entities.EventDao;

@Database(entities = {Event.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class DrinksDatabase extends RoomDatabase {

    private static volatile DrinksDatabase INSTANCE;

    public static DrinksDatabase getInstance(Context context) {

        if (INSTANCE == null) {
            synchronized (DrinksDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DrinksDatabase.class, "drinks.db")
                            .build();
                }
            }

        }
        return INSTANCE;
    }

    public abstract EventDao eventDao();
    // public abstract IngredientDao ingredientDao();
    // public abstract RecipeDao recipeDao();

}
