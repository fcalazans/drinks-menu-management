package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ingredient")
public class Ingredient {
    @PrimaryKey(autoGenerate = true)
    public int ingredient_id;

    @ColumnInfo(name = "ingredient_name")
    public String ingredientName;

    @ColumnInfo(name = "description")
    public String ingredientDescription;

    @ColumnInfo(name = "category")
    public String ingredientCategory;

    @ColumnInfo(name = "ingredient_img")
    public String ingredientImg;

}
