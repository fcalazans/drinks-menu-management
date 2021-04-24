package com.fcalazans.drinksmenumanagement;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fcalazans.drinksmenumanagement.adapters.EventAdapter;
import com.fcalazans.drinksmenumanagement.viewmodel.MainViewModel;

public class MainActivity2 extends AppCompatActivity {
    MainViewModel eventViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_DrinksMenuManagement);

        setContentView(R.layout.activity_main2);

        RecyclerView recyclerView = findViewById(R.id.event_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final EventAdapter adapter = new EventAdapter();
        recyclerView.setAdapter(adapter);

        eventViewModel = new MainViewModel(getApplication());
        eventViewModel.getAllEvents().observe(this, adapter::setEvents);
    }

}