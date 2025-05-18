package com.notabnsol.jetpack_compose_assignment_2.ui.TodosStates

sealed interface TodosEvent {
    data class OnTodoClick(val id: Int) : TodosEvent
}