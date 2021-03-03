package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Glass")
public class Glass {
    @PrimaryKey(autoGenerate = true)
    public int glass_id;

    @ColumnInfo(name = "glass_name")
    public String glassName;

    @ColumnInfo(name = "glass_description")
    public String glassDescription;

    @ColumnInfo(name = "glass_size")
    public String glassSize;

}
