package com.ui.simpletodo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
    var isExpanded by remember { mutableStateOf(false) }
    var category by remember { mutableStateOf(0) }
    val categoryNames = listOf<String>("High","Mid","Low")
    var selectedCategory by remember { mutableStateOf("Priority") }
    Column(modifier = Modifier.height(200.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),value = title , onValueChange ={ title = it} , label = { Text(text = "Task Title" )})
        Text(text = selectedCategory , modifier = Modifier.clickable { isExpanded = true })
        DropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
            categoryNames.forEachIndexed{
                index,title->
                DropdownMenuItem(text = { Text(text = title) }, onClick = { category = index
                    selectedCategory =  title
                isExpanded = false})
            }
        }
    }

}

@Preview
@Composable
fun mainPreview(){
    BottomSheetForm()
}