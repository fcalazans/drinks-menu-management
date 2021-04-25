package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "recipe",
        foreignKeys = {@ForeignKey(entity = Glass.class,
                parentColumns = "glass_id",
                childColumns = "glass_id",
                onDelete = ForeignKey.NO_ACTION,
                onUpdate = ForeignKey.NO_ACTION)
        },
        indices = {@Index(value = {"glass_id"})}
)
public class Recipe {
    @PrimaryKey(autoGenerate = true)
    public int recipe_id;

    @ColumnInfo(name = "recipe_name")
    @NonNull
    public String recipeName;

    @ColumnInfo(name = "glass_id")
    public Integer glassId;

    @ColumnInfo(name = "comment")
    public String recipeComment;

    @ColumnInfo(name = "recipe_description")
    public String recipeDescription;

}
