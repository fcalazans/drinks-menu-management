package com.fcalazans.drinksmenumanagement.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.fcalazans.drinksmenumanagement.database.entities.Unit;

import java.util.List;

@Dao
public interface UnitDao {

    @Query("SELECT * FROM unit ORDER BY unit_name ASC")
    LiveData<List<Unit>> getAllUnits();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUnit(Unit unit);

    @Update
    void updateUnit(Unit unit);

    @Delete
    void deleteUnit(Unit unit);

//    @Transaction
//    @Query("SELECT * FROM Category")
//    LiveData<List<EventWithUnit>> getEventWithUnit();
//
//    @Transaction
//    @Query("SELECT * FROM Unit")
//    LiveData<List<UnitWithEvent>> getUnitWithEvent();

}