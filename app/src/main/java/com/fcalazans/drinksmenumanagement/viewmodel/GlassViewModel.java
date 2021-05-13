package com.fcalazans.drinksmenumanagement.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.fcalazans.drinksmenumanagement.database.entities.Glass;
import com.fcalazans.drinksmenumanagement.database.repository.GlassRepository;

import java.util.List;

public class GlassViewModel extends AndroidViewModel {


    // GLASS
    private final LiveData<List<Glass>> allGlasses;
    private final GlassRepository glassRepository;

    public GlassViewModel(@NonNull Application application) {
        super(application);

        // GLASS
        glassRepository = new GlassRepository(application);
        allGlasses = glassRepository.getAllGlasses();

    }

    // GLASS
    public void insert(Glass glass) {
        glassRepository.insert(glass);
    }

    public void update(Glass glass) {
        glassRepository.update(glass);
    }

    public void delete(Glass glass) {
        glassRepository.delete(glass);
    }

    public LiveData<List<Glass>> getAllGlasses() {
        return allGlasses;
    }
}
