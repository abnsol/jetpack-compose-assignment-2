package com.notabnsol.jetpack_compose_assignment_2.data.api

import com.notabnsol.jetpack_compose_assignment_2.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: TodoApi by lazy {
        retrofit.create(TodoApi::class.java)
    }
}