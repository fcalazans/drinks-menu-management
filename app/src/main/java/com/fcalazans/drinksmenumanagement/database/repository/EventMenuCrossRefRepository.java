package com.fcalazans.drinksmenumanagement.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.fcalazans.drinksmenumanagement.database.DrinksDatabase;
import com.fcalazans.drinksmenumanagement.database.dao.EventMenuCrossRefDao;
import com.fcalazans.drinksmenumanagement.database.relations.EventWithMenu;
import com.fcalazans.drinksmenumanagement.database.relations.MenuWithEvent;

import java.util.List;

public class EventMenuCrossRefRepository {
    private final EventMenuCrossRefDao eventMenuCrossRefDao;
    private final LiveData<List<EventWithMenu>> allEventWithMenu;
    private final LiveData<List<MenuWithEvent>> allMenuWithEvent;

    public EventMenuCrossRefRepository(Application application) {
        DrinksDatabase drinksDatabase = DrinksDatabase.getInstance(application);
        eventMenuCrossRefDao = drinksDatabase.eventMenuCrossRefDao();
        allEventWithMenu = eventMenuCrossRefDao.getEventWithMenu();
        allMenuWithEvent = eventMenuCrossRefDao.getMenuWithEvent();
    }

    public LiveData<List<EventWithMenu>> getEventWithMenu() {
        return allEventWithMenu;
    }

    public LiveData<List<MenuWithEvent>> getMenuWithEvent() {
        return allMenuWithEvent;
    }


}
