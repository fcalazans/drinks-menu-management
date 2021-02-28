package com.fcalazans.drinksmenumanagement.database.entities;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.fcalazans.drinksmenumanagement.database.DrinksDatabase;

import java.util.List;

public class EventRepository {
    private EventDao eventDao;
    private DrinksDatabase drinksDatabase;
    private LiveData<List<Event>> allEvents;

    public EventRepository(Application application) {
        drinksDatabase = DrinksDatabase.getInstance(application);
        eventDao = drinksDatabase.eventDao();
        allEvents = eventDao.getAllEvents();
    }

    // Revise this method.
    public void insert(Event event) {
        eventDao.insertEvent(event);
    }

    public LiveData<List<Event>> getAllEvents() {
        return eventDao.getAllEvents();
    }
}
