package com.example.domain

class GetCourseUseCase(private val courseRepository: CourseRepository) {

    fun getCourseUseCase(courseId: Int): Course =
        courseRepository.getCourseDomainInterface(courseId)
}