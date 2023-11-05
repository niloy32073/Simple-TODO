package com.ui.simpletodo.components

import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import com.ui.simpletodo.data.Task
import com.ui.simpletodo.data.TaskViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.Check
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@Composable
fun TaskList(list: List<Task>, taskViewModel: TaskViewModel) {
    val context = LocalContext.current
    //swipe action
    LazyColumn(){
        items(list){task ->
            var isCompleted = rememberSaveable {
                mutableStateOf(task.isCompleted())
            }
            val deleteItem = SwipeAction(
                icon = rememberVectorPainter(image = Icons.Filled.Delete),//Icons.Default.Delete,
                background = Color(0xFFEB7F7F),
                onSwipe = {
                    taskViewModel.deleteTask(task)
                }
            )
            SwipeableActionsBox(
                endActions = listOf(deleteItem),
                swipeThreshold = 150.dp
            ) {
                ListItem(
                    modifier = Modifier
                        .padding(5.dp)
                        .border(BorderStroke(1.dp, Color(0xFFA3A2A2)))
                        .clickable {
                            Toast
                                .makeText(context, "Item clicked", Toast.LENGTH_SHORT)
                                .show()
                        },
                    headlineContent = {
                        Text(
                            text = task.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    },
//                    leadingContent = { IconButton(onClick = {
//                        taskViewModel.deleteTask(task)
//                    }) {
//                        Icon(Icons.Default.Delete,contentDescription = null)
//                    }
//                    },
                    supportingContent = { Text(text = task.details)},
                    trailingContent = {
                        // if(!task.isCompleted()) {
                        Checkbox(checked = isCompleted.value, onCheckedChange = {
                            isCompleted.value = it
                            task.completed = isCompleted.toString()
                            Log.d("isDone it", "${it.toString()}")
                            Log.d("isDone", "${task.completed}")
                            taskViewModel.updateTask(task)
                            Toast.makeText(context, "Todo updated", Toast.LENGTH_SHORT).show()
                        })
                        //  }
                    },
                    shadowElevation = 10.dp,
                    //tonalElevation = 5.dp
                )
            }
        }
    }
}
//fun TaskRow(taskList: List<Task>, taskViewModel: TaskViewModel){
//
//    var tittle = task.title
//    var category = task.category
//
//    val isCompleted = rememberSaveable {
//        mutableStateOf(task.isCompleted())
//    }
//
//    Row (modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.Top){
//        Column() {
//            Checkbox(checked = task.isCompleted(), onCheckedChange = {
//                isCompleted.value = it
//                task.completed = isCompleted.value.toString()
//                taskViewModel.updateTask(task)
//            })
//        }
//        Column() {
//            Text(text = tittle, fontSize = 18.sp, fontWeight = FontWeight.Bold)
//            Text(text = category, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(185,185,190))
//        }
//    }
//}
