package com.fcalazans.drinksmenumanagement.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fcalazans.drinksmenumanagement.R;
import com.fcalazans.drinksmenumanagement.database.entities.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private List<Menu> menus = new ArrayList<>();
    private OnMenuListener listener;

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View iTemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_layout_row,
                parent, false);
        return new MenuViewHolder(iTemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menu currentMenu = menus.get(position);
        holder.textViewName.setText(currentMenu.menuName);
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
        notifyDataSetChanged();
    }

    public void setOnMenuListener(OnMenuListener listener) {
        this.listener = listener;
    }

    public interface OnMenuListener {
        void onItemClick(Menu menu);
    }

    // Static removed for testing.
    public class MenuViewHolder extends RecyclerView.ViewHolder {
        final TextView textViewName;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.menu_name);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAbsoluteAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(menus.get(position));
                    }
                }
            });
        }
    }
}