package com.notabnsol.jetpack_compose_assignment_2.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.notabnsol.jetpack_compose_assignment_2.db.TodoDB

@Database(
    entities = [TodoDB::class],
    version = 1,
    exportSchema = false
)
abstract class TodoDataBase : RoomDatabase() {

    abstract val todoDao: TodoDAO
}