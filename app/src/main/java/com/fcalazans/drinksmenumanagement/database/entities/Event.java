package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Event")
public class Event {
    @PrimaryKey(autoGenerate = true)
    public int event_id;
    @ColumnInfo(name = "event_title")
    public String eventTitle;
    @ColumnInfo(name = "event_description")
    public String eventDescription;
    @ColumnInfo(name = "event_type")
    public String eventType;
    @ColumnInfo(name = "date_start")
    public String eventDateStart;
    @ColumnInfo(name = "date_end")
    public String eventDateEnd;


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
