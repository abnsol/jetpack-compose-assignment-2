package com.notabnsol.jetpack_compose_assignment_2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.notabnsol.jetpack_compose_assignment_2.ui.viewModel.TodoDetailViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TodoDetailScreen(
    todoId: Int?,
    onBack: () -> Unit = {}
) {
    val viewModel: TodoDetailViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(todoId) {
        if (todoId != null) viewModel.loadTodo(todoId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Todo Details", fontSize = 20.sp) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                backgroundColor = MaterialTheme.colors.primary
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            val todo = state.todo
            if (todo == null) {
                CircularProgressIndicator()
            } else {
                Card(
                    elevation = 8.dp,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "ID: ${todo.id}  |  User: ${todo.userId}",
                            style = MaterialTheme.typography.body2.copy(
                                color = Color.Gray,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                        )
                        Text(
                            text = todo.title,
                            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
                        )
                        Text(
                            text = if (todo.completed) "Completed" else "Not Completed",
                            color = if (todo.completed) Color(0xFF43A047) else Color(0xFFD32F2F),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}