package com.notabnsol.jetpack_compose_assignment_2.utils

import com.notabnsol.jetpack_compose_assignment_2.model.Todo
import com.notabnsol.jetpack_compose_assignment_2.db.TodoDB

fun Todo.toTodoDB(): TodoDB {
    return com.notabnsol.jetpack_compose_assignment_2.db.TodoDB(
        id = this.id,
        userId = this.userId,
        title = this.title,
        completed = this.completed
    )
}

fun TodoDB.toTodo(): Todo {
    return Todo(
        id = this.id,
        title = this.title,
        userId = this.userId,
        completed = this.completed,
    )
}