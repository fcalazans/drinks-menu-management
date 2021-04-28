package com.fcalazans.drinksmenumanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fcalazans.drinksmenumanagement.adapters.RecipeAdapter;
import com.fcalazans.drinksmenumanagement.database.entities.Recipe;
import com.fcalazans.drinksmenumanagement.viewmodel.MainViewModel;

public class RecipeActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private final RecipeAdapter adapter = new RecipeAdapter();
    private MainViewModel recipeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_DrinksMenuManagement);

        setContentView(R.layout.activity_recipe);

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

    /**
     * Called when the user submits the query. This could be due to a key press on the
     * keyboard or due to pressing a submit button.
     * The listener can override the standard behavior by returning true
     * to indicate that it has handled the submit request. Otherwise return false to
     * let the SearchView handle the submission by launching any associated intent.
     *
     * @param query the query text that is to be submitted
     * @return true if the query has been handled by the listener, false to let the
     * SearchView perform the default action.
     */
    @Override
    public boolean onQueryTextSubmit(String query) {
        if (query != null) {
            searchDatabase(query);
        }
        return true;
    }

    /**
     * Called when the query text is changed by the user.
     *
     * @param query the new content of the query text field.
     * @return false if the SearchView should perform the default action of showing any
     * suggestions if available, true if the action was handled by the listener.
     */
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