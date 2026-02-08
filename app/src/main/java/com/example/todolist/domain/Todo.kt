package com.example.todolist.domain

data class Todo(
    val id: Long,
    val title: String,
    val description: String?,
    val isCompleted: Boolean,
    val userId: String
)

// fake objects
val todo1 = Todo(
    id = 1,
    title = "Todo 1",
    description = "Description for Todo 1",
    isCompleted = false,
    userId = "user_teste"
)

val todo2 = Todo(
    id = 2,
    title = "Todo 2",
    description = "Description for Todo 2",
    isCompleted = true,
    userId = "user_teste"
)

val todo3 = Todo(
    id = 3,
    title = "Todo 3",
    description = "Description for Todo 3",
    isCompleted = false,
    userId = "user_teste"
)