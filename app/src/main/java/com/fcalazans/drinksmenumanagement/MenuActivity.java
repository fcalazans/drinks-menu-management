package com.fcalazans.drinksmenumanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fcalazans.drinksmenumanagement.adapters.MenuAdapter;
import com.fcalazans.drinksmenumanagement.database.entities.Menu;
import com.fcalazans.drinksmenumanagement.viewmodel.MainViewModel;

public class MenuActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    final MenuAdapter adapter = new MenuAdapter();
    MainViewModel menuViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_DrinksMenuManagement);

        setContentView(R.layout.activity_menu);

        RecyclerView recyclerView = findViewById(R.id.menu_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        recyclerView.setAdapter(adapter);

        menuViewModel = new MainViewModel(getApplication());
        menuViewModel.getAllMenus().observe(this, adapter::setMenus);

        adapter.setOnMenuListener(new MenuAdapter.OnMenuListener() {
            @Override
            public void onItemClick(Menu menu) {
                Intent intent = new Intent(getApplicationContext(), MenuDetailActivity.class);
                intent.putExtra("menu_name", menu.menuName);
                intent.putExtra("menu_id", menu.menu_id);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
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
            searchMenuDatabase(query);
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
            searchMenuDatabase(query);
        }
        return true;
    }

    /**
     * @param query the final query.
     */
    private void searchMenuDatabase(String query) {
        menuViewModel.searchMenuDatabase("%" + query + "%").observe(this, adapter::setMenus);
    }
}