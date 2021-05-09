package com.fcalazans.drinksmenumanagement.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.fcalazans.drinksmenumanagement.database.entities.Glass;

import java.util.List;

@Dao
public interface GlassDao {

    @Query("SELECT * FROM glass ORDER BY glass_name ASC")
    LiveData<List<Glass>> getAllGlasses();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGlass(Glass glass);

    @Update
    void updateGlass(Glass glass);

    @Delete
    void deleteGlass(Glass glass);

    @Query("SELECT * FROM glass WHERE glass_name LIKE :searchQuery OR glass_description LIKE :searchQuery")
    LiveData<List<Glass>> searchDatabase(String searchQuery);
//
//    @Transaction
//    @Query("SELECT * FROM Menu")
//    LiveData<List<MenuWithEvent>> getMenuWithEvent();

}