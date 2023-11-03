package com.ui.simpletodo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo("title")val tittle:String,
    @ColumnInfo("category")val category:String = "Default",
    @ColumnInfo("date")val date: Int,
    @ColumnInfo("status")val status: String = (false).toString()
)
