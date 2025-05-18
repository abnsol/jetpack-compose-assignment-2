package com.notabnsol.jetpack_compose_assignment_2.ui.TodosStates

import com.notabnsol.jetpack_compose_assignment_2.model.Todo

data class TodosState(
    val todoList: List<Todo> = emptyList(),
)
