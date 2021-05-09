package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "recipe_garnish",
        primaryKeys = {"recipe_id", "garnish_id"},
        foreignKeys = {
                @ForeignKey(entity = Recipe.class,
                        parentColumns = "recipe_id",
                        childColumns = "recipe_id",
                        onUpdate = ForeignKey.CASCADE,
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Garnish.class,
                        parentColumns = "garnish_id",
                        childColumns = "garnish_id",
                        onUpdate = ForeignKey.CASCADE,
                        onDelete = ForeignKey.CASCADE)
        },
        indices = {@Index(value = {"recipe_id"}), @Index(value = {"garnish_id"})}
)
public class RecipeGarnishCrossRef {

    @ColumnInfo(name = "recipe_id")
    public int recipeId;

    @ColumnInfo(name = "garnish_id")
    public int garnishId;

    @ColumnInfo(name = "quantity")

    @NonNull
    public Double quantity;


}
