package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(
        primaryKeys = {"event_id", "menu_id"},
        foreignKeys = {
                @ForeignKey(entity = Event.class,
                        parentColumns = "event_id",
                        childColumns = "event_id"),
                @ForeignKey(entity = Menu.class,
                        parentColumns = "menu_id",
                        childColumns = "menu_id")
        },
        indices = {@Index(value = {"menu_id"})}
)
public class EventMenuCrossRef {

    @ColumnInfo(name = "event_id")
    public int eventId;

    @ColumnInfo(name = "menu_id")
    public int menuId;
}
