package com.fcalazans.drinksmenumanagement.database.relations;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.fcalazans.drinksmenumanagement.database.entities.Garnish;
import com.fcalazans.drinksmenumanagement.database.entities.Recipe;
import com.fcalazans.drinksmenumanagement.database.entities.RecipeGarnishCrossRef;

import java.util.List;


public class GarnishWithRecipe {
    @Embedded
    public Garnish garnish;
    @Relation(
            parentColumn = "garnish_id",
            entityColumn = "recipe_id",
            associateBy = @Junction(RecipeGarnishCrossRef.class)
    )
    public List<Recipe> recipes;

}
