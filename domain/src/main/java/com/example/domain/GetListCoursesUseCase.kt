package com.example.domain

class GetListCoursesUseCase(private val courseRepositoryInterface: CourseRepositoryInterface) {

    suspend fun getListCoursesUseCase(): List<Course> =
        courseRepositoryInterface.getCoursesListDomainInterface()
}