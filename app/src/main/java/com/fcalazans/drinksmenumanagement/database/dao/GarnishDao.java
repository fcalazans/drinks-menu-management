package com.fcalazans.drinksmenumanagement.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.fcalazans.drinksmenumanagement.database.entities.Garnish;

import java.util.List;

@Dao
public interface GarnishDao {

    @Query("SELECT * FROM garnish ORDER BY garnish_name ASC")
    LiveData<List<Garnish>> getAllGarnishes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGarnish(Garnish garnish);

    @Update
    void updateGarnish(Garnish garnish);

    @Delete
    void deleteGarnish(Garnish garnish);

//    @Transaction
//    @Query("SELECT * FROM Category")
//    LiveData<List<EventWithMenu>> getEventWithMenu();
//
//    @Transaction
//    @Query("SELECT * FROM Menu")
//    LiveData<List<MenuWithEvent>> getMenuWithEvent();

}