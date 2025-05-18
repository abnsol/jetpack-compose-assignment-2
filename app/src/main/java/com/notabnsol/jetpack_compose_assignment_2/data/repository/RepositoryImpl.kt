package com.notabnsol.jetpack_compose_assignment_2.repository

import com.notabnsol.jetpack_compose_assignment_2.data.api.TodoApi
import com.notabnsol.jetpack_compose_assignment_2.domain.repository.Repository
import com.notabnsol.jetpack_compose_assignment_2.model.Todo
import com.notabnsol.jetpack_compose_assignment_2.db.TodoDAO
import com.notabnsol.jetpack_compose_assignment_2.utils.toTodo
import com.notabnsol.jetpack_compose_assignment_2.utils.toTodoDB
import javax.inject.Singleton

@Singleton
class RepositoryImpl(
    private val api: TodoApi,
    private val todoDAO: TodoDAO
) : Repository {

    override suspend fun getTodos(): List<Todo> {
        val localTodos = todoDAO.getAllTodos()

        return if (localTodos.isNotEmpty()) {
            localTodos.map { it.toTodo() }
        } else {
            val response = api.getTodos()
            try {
                val todos = response
                todos.forEach { todoDAO.upsertTodo(it.toTodoDB()) }
                todos
            } catch (e: Exception) {
                emptyList()
            }
        }
    }

    override suspend fun getTodoById(id: Int): Todo {
        val localTodo = todoDAO.getTodoFromDB(id)
        return localTodo?.toTodo() ?: run {
            val todo = api.getTodoById(id)
            todoDAO.upsertTodo(todo.toTodoDB())
            todo
        }
    }

}
