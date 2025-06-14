package com.example.data.di

import com.example.data.CourseRepositoryImpl
import dagger.Component

@Component(modules = [DataModule::class])
interface CourseRepositoryImplComponent {

    fun injectCourseRepositoryImpl(repositoryImpl: CourseRepositoryImpl)
}