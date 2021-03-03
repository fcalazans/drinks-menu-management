package com.fcalazans.drinksmenumanagement.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.fcalazans.drinksmenumanagement.database.entities.Event;
import com.fcalazans.drinksmenumanagement.database.entities.EventDao;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Event.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class DrinksDatabase extends RoomDatabase {

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static volatile DrinksDatabase INSTANCE;
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                EventDao dao = INSTANCE.eventDao();

                Event event1 = new Event("Event1",
                        "Some Description",
                        "Wedding",
                        new Date(20210303),
                        new Date(20210303));
                dao.insertEvent(event1);
                Event event2 = new Event("Event2",
                        "Some Description",
                        "Business",
                        new Date(20210303),
                        new Date(20210303));
                dao.insertEvent(event2);
            });
        }
    };

    public static DrinksDatabase getInstance(Context context) {

        if (INSTANCE == null) {
            synchronized (DrinksDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DrinksDatabase.class, "drinks.db")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }

        }
        return INSTANCE;
    }
    // public abstract IngredientDao ingredientDao();
    // public abstract RecipeDao recipeDao();

    public abstract EventDao eventDao();

}
