package com.fcalazans.drinksmenumanagement.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.fcalazans.drinksmenumanagement.database.converters.ViewConverter;
import com.fcalazans.drinksmenumanagement.database.dao.CategoryDao;
import com.fcalazans.drinksmenumanagement.database.dao.EventDao;
import com.fcalazans.drinksmenumanagement.database.dao.EventMenuCrossRefDao;
import com.fcalazans.drinksmenumanagement.database.dao.GarnishDao;
import com.fcalazans.drinksmenumanagement.database.dao.GlassDao;
import com.fcalazans.drinksmenumanagement.database.dao.IngredientDao;
import com.fcalazans.drinksmenumanagement.database.dao.InstructionDao;
import com.fcalazans.drinksmenumanagement.database.dao.LiquorCabinetDao;
import com.fcalazans.drinksmenumanagement.database.dao.MenuDao;
import com.fcalazans.drinksmenumanagement.database.dao.MenuRecipeCrossRefDao;
import com.fcalazans.drinksmenumanagement.database.dao.RecipeDao;
import com.fcalazans.drinksmenumanagement.database.dao.UnitDao;
import com.fcalazans.drinksmenumanagement.database.entities.Category;
import com.fcalazans.drinksmenumanagement.database.entities.Event;
import com.fcalazans.drinksmenumanagement.database.entities.EventMenuCrossRef;
import com.fcalazans.drinksmenumanagement.database.entities.Garnish;
import com.fcalazans.drinksmenumanagement.database.entities.Glass;
import com.fcalazans.drinksmenumanagement.database.entities.Ingredient;
import com.fcalazans.drinksmenumanagement.database.entities.Instruction;
import com.fcalazans.drinksmenumanagement.database.entities.LiquorCabinet;
import com.fcalazans.drinksmenumanagement.database.entities.Menu;
import com.fcalazans.drinksmenumanagement.database.entities.MenuRecipeCrossRef;
import com.fcalazans.drinksmenumanagement.database.entities.Recipe;
import com.fcalazans.drinksmenumanagement.database.entities.RecipeCategoryCrossRef;
import com.fcalazans.drinksmenumanagement.database.entities.RecipeGarnishCrossRef;
import com.fcalazans.drinksmenumanagement.database.entities.RecipeIngredientCrossRef;
import com.fcalazans.drinksmenumanagement.database.entities.RecipeInstructionCrossRef;
import com.fcalazans.drinksmenumanagement.database.entities.Unit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {
        Category.class,
        Event.class,
        EventMenuCrossRef.class,
        Garnish.class,
        Glass.class,
        Ingredient.class,
        Instruction.class,
        LiquorCabinet.class,
        Menu.class,
        MenuRecipeCrossRef.class,
        Recipe.class,
        RecipeCategoryCrossRef.class,
        RecipeGarnishCrossRef.class,
        RecipeIngredientCrossRef.class,
        RecipeInstructionCrossRef.class,
        Unit.class
},
        version = 1, exportSchema = false)

@TypeConverters(ViewConverter.class)
public abstract class DrinksDatabase extends RoomDatabase {

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

        }
    };
    private static volatile DrinksDatabase INSTANCE;

    public static DrinksDatabase getInstance(Context context) {

        if (INSTANCE == null) {
            synchronized (DrinksDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DrinksDatabase.class, "drinks.db")
                            .createFromAsset("database/drinksDB_2021.db")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }

        }
        return INSTANCE;
    }

    public abstract CategoryDao categoryDao();

    public abstract EventDao eventDao();

    public abstract EventMenuCrossRefDao eventMenuCrossRefDao();

    public abstract MenuRecipeCrossRefDao MenuRecipeCrossRefDao();

    public abstract GarnishDao garnishDao();

    public abstract GlassDao glassDao();

    public abstract IngredientDao ingredientDao();

    public abstract InstructionDao instructionDao();

    public abstract LiquorCabinetDao liquorCabinetDao();

    public abstract MenuDao menuDao();

    public abstract RecipeDao recipeDao();

    public abstract UnitDao unitDao();

}
