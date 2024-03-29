package com.fcalazans.drinksmenumanagement.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.fcalazans.drinksmenumanagement.database.entities.Menu;

import java.util.List;

@Dao
public interface MenuDao {

    @Query("SELECT * FROM menu ORDER BY menu_id DESC")
    LiveData<List<Menu>> getAllMenus();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMenu(Menu menu);

    @Update
    void updateMenu(Menu menu);

    @Delete
    void deleteMenu(Menu menu);

//    @Transaction
//    @Query("SELECT * FROM Category")
//    LiveData<List<EventWithMenu>> getEventWithMenu();

    @Query("SELECT * FROM menu WHERE menu_name LIKE :searchQuery")
    LiveData<List<Menu>> searchMenuDatabase(String searchQuery);

}