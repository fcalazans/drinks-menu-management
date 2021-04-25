package com.fcalazans.drinksmenumanagement;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fcalazans.drinksmenumanagement.adapters.RecipeAdapter;
import com.fcalazans.drinksmenumanagement.viewmodel.MainViewModel;

public class RecipeActivity extends AppCompatActivity {
    MainViewModel recipeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_DrinksMenuManagement);

        setContentView(R.layout.activity_recipe);

        RecyclerView recyclerView = findViewById(R.id.recipe_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final RecipeAdapter adapter = new RecipeAdapter();
        recyclerView.setAdapter(adapter);

        recipeViewModel = new MainViewModel(getApplication());
        recipeViewModel.getAllRecipes().observe(this, adapter::setRecipes);
    }

}