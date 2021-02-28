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

}
// Add constructors?
