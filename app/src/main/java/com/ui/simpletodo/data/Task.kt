package com.ui.simpletodo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true) val id:Int?,
    @ColumnInfo("title") var title:String,
    @ColumnInfo("details") var details: String,
    @ColumnInfo("category") var category:String = "Default",
    @ColumnInfo("date") var date: Int,
    @ColumnInfo("completed") var completed: String = (false).toString()
){
    fun isCompleted(): Boolean = if(completed == (false).toString()) false else true
}
