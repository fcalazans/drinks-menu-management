package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "unit")
public class Unit {
    @PrimaryKey(autoGenerate = true)
    public int unit_id;

    @ColumnInfo(name = "unit_name")
    @NonNull
    public String unitName;

}
