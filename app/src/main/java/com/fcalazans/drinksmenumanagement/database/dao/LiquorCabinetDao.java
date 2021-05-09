package com.fcalazans.drinksmenumanagement.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.fcalazans.drinksmenumanagement.database.entities.LiquorCabinet;

import java.util.List;

@Dao
public interface LiquorCabinetDao {

    @Query("SELECT * FROM liquor_cabinet")
    LiveData<List<LiquorCabinet>> getAllLiquorCabinets();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLiquorCabinet(LiquorCabinet liquorCabinet);

    @Update
    void updateLiquorCabinet(LiquorCabinet liquorCabinet);

    @Delete
    void deleteLiquorCabinet(LiquorCabinet liquorCabinet);

}
