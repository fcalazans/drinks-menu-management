package com.fcalazans.drinksmenumanagement.database.relations;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.fcalazans.drinksmenumanagement.database.entities.Menu;
import com.fcalazans.drinksmenumanagement.database.entities.MenuRecipeCrossRef;
import com.fcalazans.drinksmenumanagement.database.entities.Recipe;

import java.util.List;


public class MenuWithRecipe {
    @Embedded
    public Menu menu;
    @Relation(
            parentColumn = "menu_id",
            entityColumn = "recipe_id",
            associateBy = @Junction(MenuRecipeCrossRef.class)
    )
    public List<Recipe> recipes;

}
