package com.example.todolist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [TodoEntity::class],
    /** Gemini - início
     * Prompt: O app rodou, exibiu lista vazia mesmo para um usuario que possuia tasks e
     * crashou. Como resolver esse erro?
     */
    version = 2, // codigo gerado para recriar o banco automaticamente e evitar crash
    /** Gemini - final */

)
abstract class TodoDatabase : RoomDatabase(){

    abstract val todoDao: TodoDao
}

object TodoDatabaseProvider {

    @Volatile
    private var INSTANCE: TodoDatabase? = null

    fun provide(context: Context): TodoDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                TodoDatabase::class.java,
                "todo-app"
            )
                /** Gemini - início
                 * Prompt: O app rodou, exibiu lista vazia mesmo para um usuario que possuia tasks e
                 * crashou. Como resolver esse erro?
                 */
                .fallbackToDestructiveMigration() // Código gerado para recriar o banco automaticamente e evitar crash
                /** Gemini - final */
                .build()
            INSTANCE = instance
            instance
        }
    }
}