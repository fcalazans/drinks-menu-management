package com.fcalazans.drinksmenumanagement.database.relations;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.fcalazans.drinksmenumanagement.database.entities.Instruction;
import com.fcalazans.drinksmenumanagement.database.entities.Recipe;
import com.fcalazans.drinksmenumanagement.database.entities.RecipeInstructionCrossRef;

import java.util.List;


public class RecipeWithInstruction {
    @Embedded
    public Recipe recipe;
    @Relation(
            parentColumn = "recipe_id",
            entityColumn = "instruction_id",
            associateBy = @Junction(RecipeInstructionCrossRef.class)
    )
    public List<Instruction> instructions;

}
