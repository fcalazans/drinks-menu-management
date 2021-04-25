package com.fcalazans.drinksmenumanagement.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.fcalazans.drinksmenumanagement.database.DrinksDatabase;
import com.fcalazans.drinksmenumanagement.database.dao.MenuDao;
import com.fcalazans.drinksmenumanagement.database.entities.Menu;

import java.util.List;

public class MenuRepository {
    private final MenuDao menuDao;
    private final LiveData<List<Menu>> allMenus;

    public MenuRepository(Application application) {
        DrinksDatabase drinksDatabase = DrinksDatabase.getInstance(application);
        menuDao = drinksDatabase.menuDao();
        allMenus = menuDao.getAllMenus();

    }

    public LiveData<List<Menu>> getAllMenus() {
        return allMenus;
    }


    public void insert(Menu menu) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> menuDao.insertMenu(menu));
    }

    public void update(Menu menu) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> menuDao.updateMenu(menu));
    }

    public void delete(Menu menu) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> menuDao.deleteMenu(menu));
    }

}
