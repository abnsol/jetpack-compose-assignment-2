package com.notabnsol.jetpack_compose_assignment_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.notabnsol.jetpack_compose_assignment_2.ui.screens.TodoDetailScreen
import com.notabnsol.jetpack_compose_assignment_2.ui.screens.TodoListScreen
import com.notabnsol.jetpack_compose_assignment_2.ui.theme.Jetpackcomposeassignment2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Jetpackcomposeassignment2Theme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "todo_list") {
                    composable("todo_list") {
                        TodoListScreen(
                            onTodoClick = { todoId ->
                                navController.navigate("todo_detail/$todoId")
                            }
                        )
                    }
                    composable("todo_detail/{todoId}") { backStackEntry ->
                        val todoId = backStackEntry.arguments?.getString("todoId")?.toIntOrNull()
                        TodoDetailScreen(
                            todoId = todoId,
                            onBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}