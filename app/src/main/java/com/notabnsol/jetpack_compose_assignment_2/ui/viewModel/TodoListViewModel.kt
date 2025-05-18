package com.notabnsol.jetpack_compose_assignment_2.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notabnsol.jetpack_compose_assignment_2.domain.repository.Repository
import com.notabnsol.jetpack_compose_assignment_2.ui.TodosStates.TodosEvent
import com.notabnsol.jetpack_compose_assignment_2.ui.TodosStates.TodosState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository : Repository
) : ViewModel() {
    private val _state = MutableStateFlow(TodosState())
    val state: StateFlow<TodosState> = _state

    fun fetchTodos() {
        viewModelScope.launch {
            val response = repository.getTodos()
            _state.value = TodosState(todoList = response)
        }
    }

    fun onEvent(event: TodosEvent) {
        when (event) {
            is TodosEvent.OnTodoClick -> {
                onTodoClick(event.id)
            }
        }
    }

    init {
        fetchTodos()
    }

    private fun onTodoClick(id: Int) {
        // Implement your logic here, e.g., fetch single todo, navigate, etc.
    }
}