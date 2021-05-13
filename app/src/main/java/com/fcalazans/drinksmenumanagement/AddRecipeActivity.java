package com.fcalazans.drinksmenumanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fcalazans.drinksmenumanagement.database.entities.Glass;
import com.fcalazans.drinksmenumanagement.viewmodel.GlassViewModel;

import java.util.ArrayList;
import java.util.List;

public class AddRecipeActivity extends AppCompatActivity {

    private GlassViewModel glassViewModel;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_DrinksMenuManagement);
        setContentView(R.layout.activity_add_recipe);

        // Set title page name.
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Insert New Recipe");
        }


        List<Glass> glassList = new ArrayList<>();
        List<String> glassListNames = new ArrayList<>();
        List<Integer> glassListIds = new ArrayList<>();

        glassViewModel = new GlassViewModel(getApplication());
        spinner = findViewById(R.id.spinner_glass);

        glassViewModel.getAllGlasses().observe(this, glasses -> {
            assert glasses != null;
            for (Glass item : glasses) {
                glassListNames.add(item.glassName);
                glassListIds.add(item.glass_id);
            }
            glassList.addAll(glasses);
        });

        ArrayAdapter<Glass> adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_spinner_item, glassList);
        spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Glass glass = (Glass) parent.getItemAtPosition(position);
                displaySpinnerName(glass);
                Toast.makeText(AddRecipeActivity.this, "Glass " + glass + "Selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        adapter.notifyDataSetChanged();

    }

    // Debug this
    public void getSelectedGlass(View view) {

        Glass glass = (Glass) AddRecipeActivity.this.spinner.getSelectedItem();
        displaySpinnerName(glass);
    }

    public void displaySpinnerName(Glass glass) {
        Toast.makeText(this, "Glass " + glass + " selected", Toast.LENGTH_SHORT).show();
    }

}


