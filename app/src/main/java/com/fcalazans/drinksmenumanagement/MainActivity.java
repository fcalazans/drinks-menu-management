package com.fcalazans.drinksmenumanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_DrinksMenuManagement);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        CardView drinks = findViewById(R.id.drinks);
        CardView menus = findViewById(R.id.menus);
        CardView events = findViewById(R.id.events);

        drinks.setOnClickListener(v -> openDrinksActivity());

        menus.setOnClickListener(v -> openMenusActivity());

        events.setOnClickListener(v -> openEventsActivity());

    }

    private void openDrinksActivity() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    private void openMenusActivity() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    private void openEventsActivity() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}