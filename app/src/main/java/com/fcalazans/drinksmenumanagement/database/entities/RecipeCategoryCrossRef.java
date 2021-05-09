package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "recipe_category",
        primaryKeys = {"recipe_id", "category_id"},
        foreignKeys = {
                @ForeignKey(entity = Recipe.class,
                        parentColumns = "recipe_id",
                        childColumns = "recipe_id",
                        onUpdate = ForeignKey.CASCADE,
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Category.class,
                        parentColumns = "category_id",
                        childColumns = "category_id",
                        onUpdate = ForeignKey.CASCADE,
                        onDelete = ForeignKey.CASCADE)
        },
        indices = {@Index(value = {"recipe_id"}), @Index(value = {"category_id"})}
)
public class RecipeCategoryCrossRef {

    @ColumnInfo(name = "recipe_id")
    public int recipeId;

    @ColumnInfo(name = "category_id")
    public int categoryId;
}
