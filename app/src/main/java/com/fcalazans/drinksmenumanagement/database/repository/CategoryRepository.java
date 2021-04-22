package com.fcalazans.drinksmenumanagement.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.fcalazans.drinksmenumanagement.database.DrinksDatabase;
import com.fcalazans.drinksmenumanagement.database.dao.CategoryDao;
import com.fcalazans.drinksmenumanagement.database.entities.Category;

import java.util.List;

public class CategoryRepository {
    private final CategoryDao categoryDao;
    private final LiveData<List<Category>> allCategories;

    public CategoryRepository(Application application) {
        DrinksDatabase drinksDatabase = DrinksDatabase.getInstance(application);
        categoryDao = drinksDatabase.categoryDao();
        allCategories = categoryDao.getAllCategories();
    }

    public LiveData<List<Category>> getAllCategories() {
        return allCategories;
    }

    public void insert(Category category) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> categoryDao.insertCategory(category));
    }

    public void update(Category category) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> categoryDao.updateCategory(category));
    }

    public void delete(Category category) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> categoryDao.deleteCategory(category));
    }

}
