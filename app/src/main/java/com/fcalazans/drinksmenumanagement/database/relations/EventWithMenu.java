package com.fcalazans.drinksmenumanagement.database.relations;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.fcalazans.drinksmenumanagement.database.entities.Event;
import com.fcalazans.drinksmenumanagement.database.entities.EventMenuCrossRef;
import com.fcalazans.drinksmenumanagement.database.entities.Menu;

import java.util.List;


public class EventWithMenu {
    @Embedded
    public Event event;
    @Relation(
            parentColumn = "event_id",
            entityColumn = "menu_id",
            associateBy = @Junction(EventMenuCrossRef.class)
    )
    public List<Menu> menus;

}
