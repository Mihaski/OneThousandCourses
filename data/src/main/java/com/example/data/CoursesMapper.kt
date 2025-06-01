package com.example.data

import com.example.data.network.NetworkCourse
import com.example.domain.Course

class CoursesMapper {

    fun networkToDomain(networkCourse: NetworkCourse) = Course(
        hasLike = networkCourse.hasLike,
        id = networkCourse.id,
        price = networkCourse.price,
        publishDate = networkCourse.publishDate,
        rate = networkCourse.rate,
        startDate = networkCourse.startDate,
        text = networkCourse.text,
        title = networkCourse.title,
    )

    fun listNetworkToDomain(listNetwork: List<NetworkCourse>) = listNetwork.map {
        networkToDomain(it)
    }
}