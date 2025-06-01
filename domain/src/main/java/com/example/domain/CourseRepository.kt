package com.example.domain

interface CourseRepository {

    fun getCourseDomainInterface(courseId: Int): Course

    fun getListCoursesDomainInterface(): List<Course>

}