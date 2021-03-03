package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

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
    public Date eventDateStart;
    @ColumnInfo(name = "date_end")
    public Date eventDateEnd;


    public Event(String eventTitle, String eventDescription, String eventType, Date eventDateStart, Date eventDateEnd) {
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
