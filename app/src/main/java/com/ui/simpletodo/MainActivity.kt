package com.ui.simpletodo

import android.annotation.SuppressLint
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
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ui.simpletodo.components.BottomSheetForm
import com.ui.simpletodo.screens.MainScreen
import com.ui.simpletodo.ui.theme.SimpleToDoTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleToDoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val sheetState = rememberModalBottomSheetState()
                    val scope = rememberCoroutineScope()
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
                        MainScreen()
                        if (isOpen){
                            // test code to know changes.
                            // Test 2.
                            ModalBottomSheet(sheetState =sheetState ,onDismissRequest = { isOpen = false }) {
                                BottomSheetForm()
                            }
                        }
                    }
                   
                }
            }
        }
    }
}

