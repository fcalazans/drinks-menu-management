package com.fcalazans.drinksmenumanagement.database.relations;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.fcalazans.drinksmenumanagement.database.entities.Ingredient;
import com.fcalazans.drinksmenumanagement.database.entities.Recipe;
import com.fcalazans.drinksmenumanagement.database.entities.RecipeIngredientCrossRef;

import java.util.List;


public class RecipeWithIngredient {
    @Embedded
    public Recipe recipe;
    @Relation(
            parentColumn = "recipe_id",
            entityColumn = "ingredient_id",
            associateBy = @Junction(RecipeIngredientCrossRef.class)
    )
    public List<Ingredient> ingredients;

}
