package com.ui.simpletodo.data

import androidx.lifecycle.LiveData

class TaskRepository(
    private val taskDao: TaskDao
) {
    val allTask: LiveData<List<Task>> = taskDao.getAll()

    suspend fun insertTask(task: Task){
        taskDao.insert(task)
    }
    suspend fun deleteTask(task: Task){
        taskDao.delete(task)
    }
    suspend fun updateTask(task: Task){
        taskDao.update(task)
    }
    suspend fun deleteAllTask(){
        taskDao.deleteAll()
    }
}