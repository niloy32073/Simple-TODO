package com.ui.simpletodo.data

fun gettask(): List<task> {
    return listOf<task>(task(1,"Task 1","Type 1",60,"I"), task(2,"Task 2","Type 2",60,"C"),
        task(3,"Task 3","Type 3",60,"I"), task(4,"Task 4","Type 4",60,"C"),
        task(5,"Task 5","Type 5",60,"I"), task(6,"Task 6","Type 6",60,"C"),
        task(7,"Task 7","Type 7",60,"I"), task(8,"Task 8","Type 8",60,"C"))
}