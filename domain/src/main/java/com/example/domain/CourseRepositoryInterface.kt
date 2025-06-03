package com.example.domain

interface CourseRepositoryInterface {

    suspend fun getCourseDomainInterface(courseId: Int): Course

    suspend fun getCoursesListDomainInterface(): List<Course>

}