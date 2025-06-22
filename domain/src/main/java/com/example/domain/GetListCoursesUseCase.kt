package com.example.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListCoursesUseCase @Inject constructor(private val repository: CourseRepositoryInterface) {

    fun getListCoursesUseCase(): Flow<List<Course>> =
        repository.getListCoursesFlow()
}