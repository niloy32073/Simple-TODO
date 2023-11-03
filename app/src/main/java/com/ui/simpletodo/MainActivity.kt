package com.ui.simpletodo

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ui.simpletodo.components.BottomSheetForm
import com.ui.simpletodo.data.TaskViewModel
import com.ui.simpletodo.screens.MainScreen
import com.ui.simpletodo.ui.theme.SimpleToDoTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val taskViewModel: TaskViewModel = viewModel(
                factory = object : ViewModelProvider.Factory{
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return TaskViewModel(applicationContext as Application) as  T
                    }
                }
            )
            val context = this
            SimpleToDoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val sheetState = rememberModalBottomSheetState()
                    var isOpen by remember { mutableStateOf(false) }

                    Scaffold (
                        floatingActionButtonPosition = FabPosition.End,
                        floatingActionButton = {
                            FloatingActionButton(
                                onClick = {
                                    isOpen = true
                                },
                                containerColor = Color.Blue,
                                content = {
                                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                            })
                        }
                    ){

                        MainScreen(taskViewModel,context)
                        if (isOpen){
                            ModalBottomSheet(
                                sheetState =sheetState ,
                                onDismissRequest = { isOpen = false }
                            ) {
                                BottomSheetForm(taskViewModel, context, sheetState)
                            }
                        }
                    }
                   
                }
            }
        }
    }
}

