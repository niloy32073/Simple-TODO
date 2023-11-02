package com.ui.simpletodo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BottomSheetForm(){
    var title by remember { mutableStateOf("") }
    var details by remember { mutableStateOf("") }
    var isExpanded by remember { mutableStateOf(false) }
    var category by remember { mutableStateOf(0) }
    val categoryNames = listOf<String>("High","Mid","Low")
    var selectedCategory by remember { mutableStateOf("Priority") }
    Column(modifier = Modifier.height(400.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),value = title , onValueChange ={ title = it} , label = { Text(text = "Task Title" )})
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),value = title , onValueChange ={ title = it} , label = { Text(text = "Details" )})
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Add")
        }
    }

}

@Preview
@Composable
fun mainPreview(){
    BottomSheetForm()
}