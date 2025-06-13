package com.example.data.di

import com.example.data.CourseRepositoryImpl
import com.example.data.network.RetrofitInterface
import com.example.domain.CourseRepositoryInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DataModule {

    @Provides
    fun bindCourseRepository(impl: CourseRepositoryImpl): CourseRepositoryInterface =
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