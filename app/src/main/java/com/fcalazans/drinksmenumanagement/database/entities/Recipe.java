package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Recipe")
public class Recipe {
    @PrimaryKey(autoGenerate = true)
    public int recipe_id;

    @ColumnInfo(name = "recipe_name")
    public String recipeName;

}
