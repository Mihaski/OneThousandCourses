package com.example.onethousandcourses

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Course
import com.example.domain.GetListCoursesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getListCoursesUseCase: GetListCoursesUseCase,
) : ViewModel() {

    val applicationState = MutableLiveData<List<Course>>()

    fun refreshCourses() = viewModelScope.launch {

        val list = getListCoursesUseCase.getListCoursesUseCase()
        Log.d("dataCourse", list.toString())
    }
}