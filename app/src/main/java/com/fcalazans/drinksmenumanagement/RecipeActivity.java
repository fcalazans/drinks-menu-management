package com.fcalazans.drinksmenumanagement;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fcalazans.drinksmenumanagement.adapters.RecipeAdapter;
import com.fcalazans.drinksmenumanagement.database.entities.Recipe;
import com.fcalazans.drinksmenumanagement.viewmodel.MainViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecipeActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private final RecipeAdapter adapter = new RecipeAdapter();
    private MainViewModel recipeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_DrinksMenuManagement);

        setContentView(R.layout.activity_recipe);

        // Set title page name.
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Drinks List");
        }

        FloatingActionButton fab = findViewById(R.id.button_add_recipe);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeActivity.this, AddRecipeActivity.class));
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recipe_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        recyclerView.setAdapter(adapter);

        recipeViewModel = new MainViewModel(getApplication());
        recipeViewModel.getAllRecipes().observe(this, adapter::setRecipes);

        adapter.setOnRecipeListener(new RecipeAdapter.OnRecipeListener() {
            @Override
            public void onItemClick(Recipe recipe) {
                Intent intent = new Intent(getApplicationContext(), RecipeDetailActivity.class);
                intent.putExtra("recipe_name", recipe.recipeName);
                intent.putExtra("recipe_description", recipe.recipeDescription);
                intent.putExtra("recipe_comment", recipe.recipeComment);
                intent.putExtra("recipe_glass_id", recipe.glassId);
                intent.putExtra("recipe_glass_id", recipe.recipe_id);
                startActivity(intent);
            }
        });

        // Swipe to delete functionality.
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                new AlertDialog.Builder(viewHolder.itemView.getContext())
                        .setMessage("Are you sure to delete " + adapter.getRecipeAt(viewHolder.getAbsoluteAdapterPosition()).recipeName + " ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                recipeViewModel.delete(adapter.getRecipeAt(viewHolder.getAbsoluteAdapterPosition()));
                                Toast.makeText(RecipeActivity.this, "Recipe Deleted!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .create()
                        .show();
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem search = menu.findItem(R.id.menu_search);
        SearchView searchView =
                (SearchView) search.getActionView();

        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
//        if (query != null) {
//            searchDatabase(query);
//            recipeViewModel.searchDatabase(query).getValue();
//        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        if (query != null) {
            searchDatabase(query);
        }
        return true;
    }

    /**
     * @param query the final query.
     */
    private void searchDatabase(String query) {
        recipeViewModel.searchDatabase("%" + query + "%").observe(this, adapter::setRecipes);
    }

}