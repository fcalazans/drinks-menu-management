package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Recipe",
        foreignKeys = {@ForeignKey(entity = Glass.class,
                parentColumns = "glass_id",
                childColumns = "glass_idFk",
                onDelete = ForeignKey.CASCADE)
        }
)
public class Recipe {
    @PrimaryKey(autoGenerate = true)
    public int recipe_id;

    @ColumnInfo(name = "recipe_name")
    public String recipeName;


    @ColumnInfo(name = "recipe_description")
    public String recipeDescription;


    @ColumnInfo(name = "glass_idFk")
    public String recipeGlassware;

}
