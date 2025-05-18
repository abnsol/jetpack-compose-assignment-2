package com.notabnsol.jetpack_compose_assignment_2.domain.repository

import com.notabnsol.jetpack_compose_assignment_2.model.Todo

interface Repository {
    suspend fun getTodos(): List<Todo>
    suspend fun getTodoById(id: Int): Todo
}