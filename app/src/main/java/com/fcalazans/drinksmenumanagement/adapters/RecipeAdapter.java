package com.fcalazans.drinksmenumanagement.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fcalazans.drinksmenumanagement.R;
import com.fcalazans.drinksmenumanagement.database.entities.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {
    private List<Recipe> recipes = new ArrayList<>();
    private OnRecipeListener listener;


    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View iTemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_layout_row,
                parent, false);
        return new RecipeViewHolder(iTemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe currentRecipe = recipes.get(position);
        holder.textViewName.setText(currentRecipe.recipeName);
        holder.textViewDescription.setText(currentRecipe.recipeDescription);
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
        notifyDataSetChanged();
    }

    public void setOnRecipeListener(OnRecipeListener listener) {
        this.listener = listener;
    }

    public interface OnRecipeListener {
        void onItemClick(Recipe recipe);
    }

    // Static removed for testing.
    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        final TextView textViewName;
        final TextView textViewDescription;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.recipe_name);
            textViewDescription = itemView.findViewById(R.id.recipe_description);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int mPosition = getLayoutPosition();
                    Recipe element = recipes.get(mPosition);

                    int position = getAbsoluteAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(recipes.get(position));
                    }
                }
            });
        }
    }
}

