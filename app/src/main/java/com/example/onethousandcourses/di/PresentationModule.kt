package com.example.onethousandcourses.di

import com.example.data.di.DataModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
//unused di
@Module(includes = [DataModule::class])
@InstallIn(SingletonComponent::class)
object PresentationModule