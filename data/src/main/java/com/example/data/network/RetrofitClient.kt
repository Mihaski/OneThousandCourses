package com.example.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitClient {

    @Provides
    @Singleton
    fun providesRetrofit() = Retrofit.Builder()
        .baseUrl("https://drive.usercontent.google.com/u/0/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun providesCourseService(retrofit: Retrofit) = retrofit.create(RetrofitInterface::class.java)
}