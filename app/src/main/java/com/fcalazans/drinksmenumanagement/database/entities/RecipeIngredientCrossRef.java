package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "recipe_ingredient",
        primaryKeys = {"recipe_id", "ingredient_id", "unit_id"},
        foreignKeys = {
                @ForeignKey(entity = Recipe.class,
                        parentColumns = "recipe_id",
                        childColumns = "recipe_id",
                        onUpdate = ForeignKey.CASCADE,
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Ingredient.class,
                        parentColumns = "ingredient_id",
                        childColumns = "ingredient_id",
                        onUpdate = ForeignKey.CASCADE,
                        onDelete = ForeignKey.RESTRICT),
                @ForeignKey(entity = Unit.class,
                        parentColumns = "unit_id",
                        childColumns = "unit_id",
                        onUpdate = ForeignKey.CASCADE,
                        onDelete = ForeignKey.RESTRICT)
        },
        indices = {
                @Index(value = {"recipe_id"}),
                @Index(value = {"unit_id"}),
                @Index(value = {"ingredient_id"})
        }
)
public class RecipeIngredientCrossRef {

    @ColumnInfo(name = "recipe_id")
    public int recipeId;

    @ColumnInfo(name = "ingredient_id")
    public int ingredientId;

    @ColumnInfo(name = "quantity")
    public Double quantity;


    @ColumnInfo(name = "unit_id")
    public int unitId;

    @ColumnInfo(name = "sequence_number", defaultValue = "0")
    public int sequenceNumber;

}
