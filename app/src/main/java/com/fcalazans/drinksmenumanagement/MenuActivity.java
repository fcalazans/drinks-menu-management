package com.fcalazans.drinksmenumanagement;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fcalazans.drinksmenumanagement.adapters.MenuAdapter;
import com.fcalazans.drinksmenumanagement.viewmodel.MainViewModel;

public class MenuActivity extends AppCompatActivity {
    MainViewModel menuViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_DrinksMenuManagement);

        setContentView(R.layout.activity_menu);

        RecyclerView recyclerView = findViewById(R.id.menu_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final MenuAdapter adapter = new MenuAdapter();
        recyclerView.setAdapter(adapter);

        menuViewModel = new MainViewModel(getApplication());
        menuViewModel.getAllMenus().observe(this, adapter::setMenus);
    }

}