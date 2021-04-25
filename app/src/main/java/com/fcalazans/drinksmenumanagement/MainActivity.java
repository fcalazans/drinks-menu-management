package com.fcalazans.drinksmenumanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_DrinksMenuManagement);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();

        CardView drinks = findViewById(R.id.drinks);
        CardView menus = findViewById(R.id.menus);
        CardView events = findViewById(R.id.events);

        drinks.setOnClickListener(v -> openRecipesActivity());

        menus.setOnClickListener(v -> openMenusActivity());

        events.setOnClickListener(v -> openEventsActivity());

    }

    private void openRecipesActivity() {
        Intent intent = new Intent(this, RecipeActivity.class);
        startActivity(intent);
    }

    private void openMenusActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    private void openEventsActivity() {
        Intent intent = new Intent(this, EventActivity.class);
        startActivity(intent);
    }
}