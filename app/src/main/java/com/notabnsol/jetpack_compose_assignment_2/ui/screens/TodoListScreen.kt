package com.notabnsol.jetpack_compose_assignment_2.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import com.notabnsol.jetpack_compose_assignment_2.ui.viewModel.TodoListViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListScreen(
    onTodoClick: (Int) -> Unit,
) {

    val viewModel: TodoListViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    val todoList = state.todoList


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Todo List", fontSize = 20.sp) },
                backgroundColor = MaterialTheme.colors.primary
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            if (todoList.isEmpty()) {
                Text(
                    text = "No Todos Found!",
                    modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.h6
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(todoList) { todo ->
                        TodoItem(
                            title = todo.title,
                            isCompleted = todo.completed,
                            onClick = {
                                onTodoClick(todo.id ?: 0) // Handle click event
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TodoItem(
    title: String,
    isCompleted: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
                Text(
                    text = if (isCompleted) "Completed" else "Not Completed",
                    color = if (isCompleted) Color.Green else Color.Red,
                    fontSize = 14.sp
                )
            }
        }
    }
}
