package com.fcalazans.drinksmenumanagement;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_DrinksMenuManagement);
        setContentView(R.layout.activity_menu_detail);

        String intentRecipeName = getIntent().getStringExtra("menu_name");
        getSupportActionBar().setTitle(intentRecipeName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView menuName = findViewById(R.id.menu_name);
        menuName.setText(intentRecipeName);

    }

    // Allow activity come back to parent with state.
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}