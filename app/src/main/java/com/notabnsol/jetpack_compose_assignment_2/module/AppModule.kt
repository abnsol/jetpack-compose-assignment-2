package com.notabnsol.jetpack_compose_assignment_2.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.notabnsol.jetpack_compose_assignment_2.data.api.TodoApi
import com.notabnsol.jetpack_compose_assignment_2.db.TodoDataBase
import com.notabnsol.jetpack_compose_assignment_2.domain.repository.Repository
import com.notabnsol.jetpack_compose_assignment_2.db.TodoDAO
import com.notabnsol.jetpack_compose_assignment_2.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.notabnsol.jetpack_compose_assignment_2.utils.Constants.Companion.BASE_URL
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideTodoDatabase(@ApplicationContext context: Context): TodoDataBase {
        return Room.databaseBuilder(
            context,
            TodoDataBase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    fun provideTodoDAO(db: TodoDataBase): TodoDAO {
        return db.todoDao
    }

    @Provides
    @Singleton
    fun provideTodoApi(): TodoApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodoApi::class.java)
    }

    @Provides
    @Singleton
    fun providesRepository(api: TodoApi, todoDAO: TodoDAO): Repository {
        return RepositoryImpl(api,todoDAO)
    }
}