package com.fcalazans.drinksmenumanagement;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EventDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_DrinksMenuManagement);
        setContentView(R.layout.activity_event_detail);

        String intentRecipeName = getIntent().getStringExtra("event_title");
        getSupportActionBar().setTitle(intentRecipeName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView eventName = findViewById(R.id.event_title);
        eventName.setText(intentRecipeName);

    }

    // Allow activity come back to parent with state.
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}