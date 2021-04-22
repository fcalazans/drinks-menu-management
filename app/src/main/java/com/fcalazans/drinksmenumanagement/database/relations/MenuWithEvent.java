package com.fcalazans.drinksmenumanagement.database.relations;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.fcalazans.drinksmenumanagement.database.entities.Event;
import com.fcalazans.drinksmenumanagement.database.entities.EventMenuCrossRef;
import com.fcalazans.drinksmenumanagement.database.entities.Menu;

import java.util.List;


public class MenuWithEvent {
    @Embedded
    public Menu menu;
    @Relation(
            parentColumn = "menu_id",
            entityColumn = "event_id",
            associateBy = @Junction(EventMenuCrossRef.class)
    )
    public List<Event> events;

}
