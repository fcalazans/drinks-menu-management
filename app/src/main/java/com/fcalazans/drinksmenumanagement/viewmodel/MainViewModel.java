package com.fcalazans.drinksmenumanagement.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.fcalazans.drinksmenumanagement.database.entities.Event;
import com.fcalazans.drinksmenumanagement.database.entities.EventRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    EventRepository eventRepository;
    LiveData<List<Event>> allEvents;

    public MainViewModel(@NonNull Application application) {
        super(application);
        eventRepository = new EventRepository(application);
        allEvents = eventRepository.getAllEvents();
    }

    public LiveData<List<Event>> getAllEvents() {
        return eventRepository.getAllEvents();
    }

    public void insertEvent(Event event) {
        eventRepository.insert(event);
    }
}
