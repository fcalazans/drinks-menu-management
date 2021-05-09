package com.fcalazans.drinksmenumanagement.database.relations;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.fcalazans.drinksmenumanagement.database.entities.Category;
import com.fcalazans.drinksmenumanagement.database.entities.Recipe;
import com.fcalazans.drinksmenumanagement.database.entities.RecipeCategoryCrossRef;

import java.util.List;


public class CategoryWithRecipe {
    @Embedded
    public Category category;
    @Relation(
            parentColumn = "category_id",
            entityColumn = "recipe_id",
            associateBy = @Junction(RecipeCategoryCrossRef.class)
    )
    public List<Recipe> recipes;

}
