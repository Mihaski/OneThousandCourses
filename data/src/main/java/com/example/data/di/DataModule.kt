package com.example.data.di

import android.content.Context
import com.example.data.CourseRepositoryImpl
import com.example.data.database.RoomDao
import com.example.data.database.TenHundredRoomDatabase
import com.example.data.network.RetrofitInterface
import com.example.domain.CourseRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun providesRoomDao(@ApplicationContext context: Context): RoomDao =
        TenHundredRoomDatabase.getInstance(context)
            .databaseAccessInterface()

    @Provides
    fun providesCourseRepository(impl: CourseRepositoryImpl): CourseRepositoryInterface =
        impl

    @Provides
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://drive.usercontent.google.com/u/0/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun providesCourseService(retrofit: Retrofit): RetrofitInterface =
        retrofit.create(RetrofitInterface::class.java)
}