package com.ui.simpletodo.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {

    @Query("SELECT * FROM task_table")
    fun getAll(): LiveData<List<Task>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)
    @Delete
    suspend fun delete(task: Task)
    @Update
    suspend fun update(task: Task)
    @Query("DELETE FROM task_table")
    suspend fun deleteAll()

    @Query("SELECT COUNT(*) FROM task_table ")
    fun count(): Int
}