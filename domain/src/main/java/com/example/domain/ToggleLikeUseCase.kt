package com.example.domain

import javax.inject.Inject

class ToggleLikeUseCase @Inject constructor(private val repository: CourseRepositoryInterface) {

    suspend fun toggle(courseId: Int) = repository.toggleLike(courseId)
}