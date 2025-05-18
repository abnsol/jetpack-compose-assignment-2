package com.notabnsol.jetpack_compose_assignment_2.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notabnsol.jetpack_compose_assignment_2.model.Todo
import com.notabnsol.jetpack_compose_assignment_2.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class TodoDetailState(
    val todo: Todo? = null
)

@HiltViewModel
class TodoDetailViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _state = MutableStateFlow(TodoDetailState())
    val state: StateFlow<TodoDetailState> = _state

    fun loadTodo(todoId: Int) {
        viewModelScope.launch {
            val todo = repository.getTodoById(todoId)
            _state.value = TodoDetailState(todo)
        }
    }
}