package com.example.domain

import kotlinx.coroutines.flow.Flow

interface CourseRepositoryInterface {

    fun getListCoursesFlow(): Flow<List<Course>>
}