package com.fcalazans.drinksmenumanagement.database.relations;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.fcalazans.drinksmenumanagement.database.entities.Garnish;
import com.fcalazans.drinksmenumanagement.database.entities.Recipe;
import com.fcalazans.drinksmenumanagement.database.entities.RecipeGarnishCrossRef;

import java.util.List;


public class RecipeWithGarnish {
    @Embedded
    public Recipe recipe;
    @Relation(
            parentColumn = "recipe_id",
            entityColumn = "garnish_id",
            associateBy = @Junction(RecipeGarnishCrossRef.class)
    )
    public List<Garnish> garnishes;

}
