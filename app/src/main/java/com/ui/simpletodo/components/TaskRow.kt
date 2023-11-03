package com.ui.simpletodo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ui.simpletodo.data.Task
import com.ui.simpletodo.data.TaskViewModel

@Composable
fun TaskRow(task: Task, taskViewModel: TaskViewModel){
    var tittle = task.title
    var category = task.category

    val isCompleted = rememberSaveable {
        mutableStateOf(task.isCompleted())
    }

    Row (modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.Top){
        Column() {
            Checkbox(checked = task.isCompleted(), onCheckedChange = {
                isCompleted.value = it
                task.completed = isCompleted.value.toString()
                taskViewModel.updateTask(task)
            })
        }
        Column() {
            Text(text = tittle, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = category, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(185,185,190))
        }
    }
}