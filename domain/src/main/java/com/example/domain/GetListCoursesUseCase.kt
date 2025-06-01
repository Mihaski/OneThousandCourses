package com.example.domain

class GetListCoursesUseCase(private val courseRepository: CourseRepository) {

    fun getListCoursesUseCase(): List<Course> =
        courseRepository.getListCoursesDomainInterface()
}