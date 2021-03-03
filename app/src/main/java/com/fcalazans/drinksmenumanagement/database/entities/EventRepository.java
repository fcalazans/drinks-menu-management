package com.fcalazans.drinksmenumanagement.database.entities;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.fcalazans.drinksmenumanagement.database.DrinksDatabase;

import java.util.List;

public class EventRepository {
    private EventDao eventDao;
    private LiveData<List<Event>> allEvents;

    public EventRepository(Application application) {
        DrinksDatabase drinksDatabase = DrinksDatabase.getInstance(application);
        eventDao = drinksDatabase.eventDao();
        allEvents = eventDao.getAllEvents();
    }

    public LiveData<List<Event>> getAllEvents() {
        return allEvents;
    }

    public void insert(Event event) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> {
            eventDao.insertEvent(event);
        });
    }

    public void update(Event event) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> {
            eventDao.updateEvent(event);
        });
    }

    public void delete(Event event) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> {
            eventDao.deleteEvent(event);
        });
    }

}
