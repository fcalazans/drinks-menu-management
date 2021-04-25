package com.fcalazans.drinksmenumanagement.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "instruction")
public class Instruction {
    @PrimaryKey(autoGenerate = true)
    public int instruction_id;

    @ColumnInfo(name = "instruction_name")
    @NonNull
    public String instructionName;

}
