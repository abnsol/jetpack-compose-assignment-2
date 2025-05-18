package com.notabnsol.jetpack_compose_assignment_2.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.notabnsol.jetpack_compose_assignment_2.db.TodoDB

@Dao
interface TodoDAO {
    @Upsert
    suspend fun upsertTodo(todo: TodoDB)

    @Query("SELECT * FROM TodoDB")
    suspend fun getAllTodos(): List<TodoDB>

    @Query("SELECT * FROM TodoDB WHERE id = :id")
    suspend fun getTodoFromDB(id: Int): TodoDB
}