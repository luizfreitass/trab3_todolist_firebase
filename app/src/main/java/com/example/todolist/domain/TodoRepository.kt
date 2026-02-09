package com.example.todolist.domain

import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    suspend fun insert(title: String, description: String?, id: Long? = null, userId: String)

    suspend fun updateCompleted(id: Long, isCompleted: Boolean)

    suspend fun delete(id: Long)

    fun getAll(userId: String): Flow<List<Todo>>

    suspend fun getBy(id: Long): Todo?
}