package com.fcalazans.drinksmenumanagement.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fcalazans.drinksmenumanagement.R;
import com.fcalazans.drinksmenumanagement.database.entities.Event;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private List<Event> events = new ArrayList<>();

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View iTemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_layout_row,
                parent, false);

        return new EventViewHolder(iTemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {

        Event currentEvent = events.get(position);
        holder.textViewName.setText(currentEvent.eventTitle);
        holder.textViewStartDate.setText(currentEvent.eventDateStart);
        holder.textViewEndDate.setText(currentEvent.eventDateEnd);
        holder.textViewDescription.setText(currentEvent.eventDescription);

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public void setEvents(List<Event> events) {
        this.events = events;
        notifyDataSetChanged();
    }


    public static class EventViewHolder extends RecyclerView.ViewHolder {

        final TextView textViewName;
        final TextView textViewStartDate;
        final TextView textViewEndDate;
        final TextView textViewDescription;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.event_name);
            textViewStartDate = itemView.findViewById(R.id.event_startDate);
            textViewEndDate = itemView.findViewById(R.id.event_endDate);
            textViewDescription = itemView.findViewById(R.id.event_description);

        }
    }
}
