package com.ui.simpletodo.data

fun gettask(): List<Task> {
    return listOf<Task>(Task(1,"Task 1","Type 1",60,"I"), Task(2,"Task 2","Type 2",60,"C"),
        Task(3,"Task 3","Type 3",60,"I"), Task(4,"Task 4","Type 4",60,"C"),
        Task(5,"Task 5","Type 5",60,"I"), Task(6,"Task 6","Type 6",60,"C"),
        Task(7,"Task 7","Type 7",60,"I"), Task(8,"Task 8","Type 8",60,"C"))
}