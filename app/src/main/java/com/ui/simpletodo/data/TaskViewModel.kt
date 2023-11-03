package com.ui.simpletodo.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {
    val allTask: LiveData<List<Task>>
    private val repository: TaskRepository
    init {
        val taskDao = TaskDb.getInstance(application).taskDao()
        repository = TaskRepository(taskDao)
        allTask = repository.allTask
    }

    fun inserTask(task: Task){
        viewModelScope.launch { repository.insertTask(task) }
    }
    fun deleteTask(task: Task){
        viewModelScope.launch { repository.deleteTask(task) }
    }
    fun updateTask(task: Task){
        viewModelScope.launch { repository.updateTask(task) }
    }
    fun deleteAllTask(){
        viewModelScope.launch { repository.deleteAllTask() }
    }
}