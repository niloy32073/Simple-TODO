package com.ui.simpletodo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ui.simpletodo.components.TaskRow
import com.ui.simpletodo.data.gettask
import com.ui.simpletodo.data.task


@Composable
fun MainScreen(){
    var tasklist:List<task> = gettask()
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
        Column (modifier = Modifier.fillMaxHeight(.15f).fillMaxWidth(), verticalArrangement = Arrangement.SpaceEvenly){
            Column() {
                Text("March 9, 2020", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            }
            Column (){
                Text("5 Completed, 5 Incomplete",fontWeight = FontWeight.Bold)
            }
            Divider(color = Color.Gray, modifier = Modifier.fillMaxWidth().height(2.dp))
        }

        Column(modifier = Modifier.fillMaxHeight(.5f).fillMaxWidth()) {
            Text(text = "Incomplete", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            LazyColumn(contentPadding = PaddingValues(horizontal = 8.dp)){
                items(tasklist){
                    task->
                    TaskRow(task = task)
                }
            }
        }
        Column(modifier = Modifier.fillMaxHeight().fillMaxWidth()) {
            Text(text = "Completed", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            LazyColumn(contentPadding = PaddingValues(horizontal = 8.dp)){
                items(tasklist){
                        task->
                    TaskRow(task = task)
                }
            }
        }
    }
}

@Preview
@Composable
fun mainPreview(){
    MainScreen()
}