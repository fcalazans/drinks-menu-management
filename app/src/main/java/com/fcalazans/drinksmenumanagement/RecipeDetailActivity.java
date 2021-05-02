package com.fcalazans.drinksmenumanagement;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_DrinksMenuManagement);
        setContentView(R.layout.activity_recipe_detail);

        String intentRecipeName = getIntent().getStringExtra("recipe_name");
        getSupportActionBar().setTitle(intentRecipeName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String intentRecipeDescription = getIntent().getStringExtra("recipe_description");

        TextView recipeName = findViewById(R.id.recipe_name);
        TextView recipeDescription = findViewById(R.id.recipe_description);

        recipeName.setText(intentRecipeName);
        recipeDescription.setText(intentRecipeDescription);

    }

    // Allow activity come back to parent with state.
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}