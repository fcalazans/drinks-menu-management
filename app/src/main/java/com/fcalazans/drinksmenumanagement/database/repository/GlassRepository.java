package com.fcalazans.drinksmenumanagement.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.fcalazans.drinksmenumanagement.database.DrinksDatabase;
import com.fcalazans.drinksmenumanagement.database.dao.GlassDao;
import com.fcalazans.drinksmenumanagement.database.entities.Glass;

import java.util.List;

public class GlassRepository {
    private final GlassDao glassDao;
    private final LiveData<List<Glass>> allGlasses;

    public GlassRepository(Application application) {
        DrinksDatabase drinksDatabase = DrinksDatabase.getInstance(application);
        glassDao = drinksDatabase.glassDao();
        allGlasses = glassDao.getAllGlasses();

    }

    public LiveData<List<Glass>> getAllGlasses() {
        return allGlasses;
    }


    public void insert(Glass glass) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> glassDao.insertGlass(glass));
    }

    public void update(Glass glass) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> glassDao.updateGlass(glass));
    }

    public void delete(Glass glass) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> glassDao.deleteGlass(glass));
    }

    public LiveData<List<Glass>> searchGlassDatabase(String searchQuery) {
        return glassDao.searchDatabase(searchQuery);

    }

}
