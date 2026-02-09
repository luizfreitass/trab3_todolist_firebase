package com.example.todolist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: TodoEntity)

    @Delete
    suspend fun delete(entity: TodoEntity)

    /** Gemini - início
     * Prompt: Como filtrar as tarefas por usuario, ou seja, fazer com que determinado usuario logado
     * veja apenas suas tarefas?
     */
    @Query("SELECT * FROM todos WHERE userId = :userId")
    fun getAll(userId: String): Flow<List<TodoEntity>>
    /** Gemini - final */

    @Query("SELECT * FROM todos WHERE id = :id")
    suspend fun getBy(id: Long): TodoEntity?
}