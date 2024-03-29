package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "garnish")
public class Garnish {
    @PrimaryKey(autoGenerate = true)
    public int garnish_id;

    @ColumnInfo(name = "garnish_name")
    @NonNull
    public String garnishName;

}
