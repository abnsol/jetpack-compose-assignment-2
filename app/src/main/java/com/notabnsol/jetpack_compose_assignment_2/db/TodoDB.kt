package com.notabnsol.jetpack_compose_assignment_2.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoDB (
    @PrimaryKey
    val id: Int? = null,
    val userId: Int,
    val title: String,
    val completed: Boolean,
)
