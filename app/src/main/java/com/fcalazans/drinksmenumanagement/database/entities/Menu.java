package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "menu")
public class Menu {
    @PrimaryKey(autoGenerate = true)
    public int menu_id;

    @ColumnInfo(name = "menu_name")
    public String menuName;

}
