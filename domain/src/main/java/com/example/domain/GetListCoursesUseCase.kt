package com.example.domain

import javax.inject.Inject

class GetListCoursesUseCase @Inject constructor(private val courseRepository: CourseRepositoryInterface) {

    suspend fun getListCoursesUseCase(): List<Course> =
        courseRepository.getCoursesListDomainInterface()
}