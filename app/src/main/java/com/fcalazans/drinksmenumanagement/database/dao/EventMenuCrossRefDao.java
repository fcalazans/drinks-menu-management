package com.fcalazans.drinksmenumanagement.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.fcalazans.drinksmenumanagement.database.entities.EventMenuCrossRef;
import com.fcalazans.drinksmenumanagement.database.relations.EventWithMenu;
import com.fcalazans.drinksmenumanagement.database.relations.MenuWithEvent;

import java.util.List;

@Dao
public interface EventMenuCrossRefDao {

    @Query("SELECT * FROM event_menu")
    LiveData<List<EventMenuCrossRef>> getAllEventMenuCrossRef();


    @Transaction
    @Query("SELECT * FROM Event")
    LiveData<List<EventWithMenu>> getEventWithMenu();

    @Transaction
    @Query("SELECT * FROM Menu")
    LiveData<List<MenuWithEvent>> getMenuWithEvent();

}