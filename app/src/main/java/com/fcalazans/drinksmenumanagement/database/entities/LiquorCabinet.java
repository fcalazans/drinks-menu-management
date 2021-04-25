package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "liquor_cabinet",
        foreignKeys = {@ForeignKey(entity = Ingredient.class,
                parentColumns = "ingredient_id",
                childColumns = "ingredient_id",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE)
        }
)

public class LiquorCabinet {

    @PrimaryKey
    @ColumnInfo(name = "ingredient_id")
    public int ingredientId;

}
