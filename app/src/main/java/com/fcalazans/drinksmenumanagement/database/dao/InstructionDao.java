package com.fcalazans.drinksmenumanagement.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.fcalazans.drinksmenumanagement.database.entities.Instruction;

import java.util.List;

@Dao
public interface InstructionDao {

    @Query("SELECT * FROM instruction ORDER BY instruction_name ASC")
    LiveData<List<Instruction>> getAllInstructions();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertInstruction(Instruction instruction);

    @Update
    void updateInstruction(Instruction instruction);

    @Delete
    void deleteInstruction(Instruction instruction);

//    @Transaction
//    @Query("SELECT * FROM Category")
//    LiveData<List<EventWithMenu>> getEventWithMenu();
//
//    @Transaction
//    @Query("SELECT * FROM Menu")
//    LiveData<List<MenuWithEvent>> getMenuWithEvent();

}
