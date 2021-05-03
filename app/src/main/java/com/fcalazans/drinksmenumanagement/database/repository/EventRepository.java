package com.fcalazans.drinksmenumanagement.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.fcalazans.drinksmenumanagement.database.DrinksDatabase;
import com.fcalazans.drinksmenumanagement.database.dao.EventDao;
import com.fcalazans.drinksmenumanagement.database.entities.Event;

import java.util.List;

public class EventRepository {
    private final EventDao eventDao;
    private final LiveData<List<Event>> allEvents;

    public EventRepository(Application application) {
        DrinksDatabase drinksDatabase = DrinksDatabase.getInstance(application);
        eventDao = drinksDatabase.eventDao();
        allEvents = eventDao.getAllEvents();

    }

    public LiveData<List<Event>> getAllEvents() {
        return allEvents;
    }


    public void insert(Event event) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> eventDao.insertEvent(event));
    }

    public void update(Event event) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> eventDao.updateEvent(event));
    }

    public void delete(Event event) {
        DrinksDatabase.databaseWriteExecutor.execute(() -> eventDao.deleteEvent(event));
    }

    public LiveData<List<Event>> searchEventDatabase(String searchQuery) {
        return eventDao.searchEventDatabase(searchQuery);

    }

}
