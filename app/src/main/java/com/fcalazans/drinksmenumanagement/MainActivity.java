package com.fcalazans.drinksmenumanagement;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.fcalazans.drinksmenumanagement.databinding.ActivityMainBinding;
import com.fcalazans.drinksmenumanagement.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private MainViewModel mainViewModel;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initViewModel();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


    }

    // New way to use ViewModelProvider.
    private void initViewModel() {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }


}