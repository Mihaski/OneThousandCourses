package com.example.domain

import javax.inject.Inject

class GetCourseUseCase @Inject constructor(private val courseRepository: CourseRepositoryInterface) {

    suspend fun getCourseUseCase(courseId: Int): Course =
        courseRepository.getCourseDomainInterface(courseId)
}