package com.ui.simpletodo.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ui.simpletodo.data.task

@Composable
fun TaskRow(task: task){
    var tittle = task.tittle
    var category = task.category
    var status = task.status
    var isChecked:Boolean = true
    if(status=="I")
        isChecked = false
    Row (verticalAlignment = Alignment.Top){
        Column() {
            Checkbox(checked = isChecked, onCheckedChange = { /**todo*/})
        }
        Column() {
            Text(text = tittle, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = category, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(185,185,190))
        }
    }
}