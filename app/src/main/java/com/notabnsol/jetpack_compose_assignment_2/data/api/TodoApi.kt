package com.notabnsol.jetpack_compose_assignment_2.data.api

import com.notabnsol.jetpack_compose_assignment_2.model.Todo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TodoApi {
    @GET("todos")
    suspend fun getTodos() : List<Todo>

    @GET("todos/{id}")
    suspend fun getTodoById(@Path("id") id: Int) : Todo
}