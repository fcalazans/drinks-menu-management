package com.fcalazans.drinksmenumanagement.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.fcalazans.drinksmenumanagement.database.entities.Event;
import com.fcalazans.drinksmenumanagement.database.entities.Menu;
import com.fcalazans.drinksmenumanagement.database.entities.Recipe;
import com.fcalazans.drinksmenumanagement.database.repository.EventRepository;
import com.fcalazans.drinksmenumanagement.database.repository.MenuRepository;
import com.fcalazans.drinksmenumanagement.database.repository.RecipeRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    // EVENTS
    private final LiveData<List<Event>> allEvents;
    private final EventRepository eventRepository;

    // MENUS
    private final LiveData<List<Menu>> allMenus;
    private final MenuRepository menuRepository;

    // RECIPES
    private final LiveData<List<Recipe>> allRecipes;
    private final RecipeRepository recipeRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);

        // EVENTS
        eventRepository = new EventRepository(application);
        allEvents = eventRepository.getAllEvents();

        // MENUS
        menuRepository = new MenuRepository(application);
        allMenus = menuRepository.getAllMenus();

        // RECIPES
        recipeRepository = new RecipeRepository(application);
        allRecipes = recipeRepository.getAllRecipes();

    }

    // EVENTS
    public LiveData<List<Event>> getAllEvents() {
        return allEvents;
    }

    public void insert(Event event) {
        eventRepository.insert(event);
    }

    public void update(Event event) {
        eventRepository.update(event);
    }

    public void delete(Event event) {
        eventRepository.delete(event);
    }

    // MENUS
    public LiveData<List<Menu>> getAllMenus() {
        return allMenus;
    }

    public void insert(Menu menu) {
        menuRepository.insert(menu);
    }

    public void update(Menu menu) {
        menuRepository.update(menu);
    }

    public void delete(Menu menu) {
        menuRepository.delete(menu);
    }

    // RECIPES
    public LiveData<List<Recipe>> getAllRecipes() {
        return allRecipes;
    }

    public void insert(Recipe recipe) {
        recipeRepository.insert(recipe);
    }

    public void update(Recipe recipe) {
        recipeRepository.update(recipe);
    }

    public void delete(Recipe recipe) {
        recipeRepository.delete(recipe);
    }

    public LiveData<List<Recipe>> searchDatabase(String searchQuery) {
        return recipeRepository.searchDatabase(searchQuery);
    }
}
