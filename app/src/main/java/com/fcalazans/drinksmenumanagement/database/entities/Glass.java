package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "glass")
public class Glass {
    @PrimaryKey(autoGenerate = true)
    public int glass_id;

    @ColumnInfo(name = "glass_name")
    @NonNull
    public String glassName;

    @ColumnInfo(name = "glass_description")
    public String glassDescription;

    @ColumnInfo(name = "glass_size")
    public Double glassSize;

    @ColumnInfo(name = "glass_size_ml")
    public Double glassSizeMl;

    @ColumnInfo(name = "glass_img")
    public String glassImg;

}
