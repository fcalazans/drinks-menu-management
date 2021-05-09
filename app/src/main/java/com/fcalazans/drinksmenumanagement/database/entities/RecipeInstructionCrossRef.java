package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "recipe_instruction",
        primaryKeys = {"recipe_id", "instruction_id"},
        foreignKeys = {
                @ForeignKey(entity = Recipe.class,
                        parentColumns = "recipe_id",
                        childColumns = "recipe_id",
                        onUpdate = ForeignKey.CASCADE,
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Instruction.class,
                        parentColumns = "instruction_id",
                        childColumns = "instruction_id",
                        onUpdate = ForeignKey.CASCADE,
                        onDelete = ForeignKey.RESTRICT)
        },
        indices = {@Index(value = {"recipe_id"}), @Index(value = {"instruction_id"})}
)
public class RecipeInstructionCrossRef {

    @ColumnInfo(name = "recipe_id")
    public int recipeId;

    @ColumnInfo(name = "instruction_id")
    public int instructionId;
}
