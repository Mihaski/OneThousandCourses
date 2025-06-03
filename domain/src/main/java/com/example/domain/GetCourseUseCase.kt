package com.example.domain

class GetCourseUseCase(private val courseRepositoryInterface: CourseRepositoryInterface) {

    suspend fun getCourseUseCase(courseId: Int): Course =
        courseRepositoryInterface.getCourseDomainInterface(courseId)
}