package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.fcalazans.drinksmenumanagement.database.converters.DateConverter;

@Entity(tableName = "event")
public class Event {
    @ColumnInfo(name = "event_title")
    public final String eventTitle;
    @ColumnInfo(name = "event_description")
    public final String eventDescription;
    @ColumnInfo(name = "event_type")
    public final String eventType;
    @ColumnInfo(name = "start_date")
    @TypeConverters({DateConverter.class})
    public final String eventDateStart;
    @ColumnInfo(name = "end_date")
    @TypeConverters({DateConverter.class})
    public final String eventDateEnd;
    @PrimaryKey(autoGenerate = true)
    public int event_id;


    public Event(String eventTitle, String eventDescription, String eventType, String eventDateStart, String eventDateEnd) {
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventType = eventType;
        this.eventDateStart = eventDateStart;
        this.eventDateEnd = eventDateEnd;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }
}
