package com.notabnsol.jetpack_compose_assignment_2.model

data class Todo (
    val userId: Int,
    val id: Int?,
    val title: String,
    val completed: Boolean
)