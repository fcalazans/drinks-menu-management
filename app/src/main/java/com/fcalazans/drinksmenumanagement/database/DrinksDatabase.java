package com.fcalazans.drinksmenumanagement.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.fcalazans.drinksmenumanagement.database.converters.DateConverter;
import com.fcalazans.drinksmenumanagement.database.dao.CategoryDao;
import com.fcalazans.drinksmenumanagement.database.dao.EventDao;
import com.fcalazans.drinksmenumanagement.database.dao.EventMenuCrossRefDao;
import com.fcalazans.drinksmenumanagement.database.dao.GarnishDao;
import com.fcalazans.drinksmenumanagement.database.dao.IngredientDao;
import com.fcalazans.drinksmenumanagement.database.dao.InstructionDao;
import com.fcalazans.drinksmenumanagement.database.dao.MenuDao;
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
import com.fcalazans.drinksmenumanagement.database.entities.Recipe;
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
        Recipe.class,
        Unit.class
},
        version = 1, exportSchema = false)

@TypeConverters(DateConverter.class)
public abstract class DrinksDatabase extends RoomDatabase {

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

//            databaseWriteExecutor.execute(() -> {
//
//                EventDao dao = INSTANCE.eventDao();
//
//                Event event1 = new Event("Event 1",
//                        "Some Description",
//                        "Wedding",
//                        "197906181900",
//                        "197906182200");
//                dao.insertEvent(event1);
//                Event event2 = new Event("Event 2",
//                        "Some Description",
//                        "Business",
//                        "198006181900",
//                        "198006182200");
//                dao.insertEvent(event2);
//
//                Event event3 = new Event("Event 3",
//                        "Another Description",
//                        "Cocktail",
//                        "20213011900",
//                        "202103012300");
//                dao.insertEvent(event3);
//            });
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
    // public abstract IngredientDao ingredientDao();
    // public abstract RecipeDao recipeDao();

    public abstract CategoryDao categoryDao();

    public abstract EventDao eventDao();

    public abstract EventMenuCrossRefDao eventMenuCrossRefDao();

    public abstract GarnishDao garnishDao();

    public abstract IngredientDao ingredientDao();

    public abstract InstructionDao instructionDao();

    public abstract MenuDao menuDao();

    public abstract RecipeDao recipeDao();

    public abstract UnitDao unitDao();

}
