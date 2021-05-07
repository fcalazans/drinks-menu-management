package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "menu_recipe",
        primaryKeys = {"recipe_id", "menu_id"},
        foreignKeys = {
                @ForeignKey(entity = Recipe.class,
                        parentColumns = "recipe_id",
                        childColumns = "recipe_id",
                        onUpdate = ForeignKey.CASCADE,
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Menu.class,
                        parentColumns = "menu_id",
                        childColumns = "menu_id",
                        onUpdate = ForeignKey.CASCADE,
                        onDelete = ForeignKey.CASCADE)
        },
        indices = {@Index(value = {"menu_id"})}
)
public class MenuRecipeCrossRef {

    @ColumnInfo(name = "recipe_id")
    public int recipeId;

    @ColumnInfo(name = "menu_id")
    public int menuId;
}
