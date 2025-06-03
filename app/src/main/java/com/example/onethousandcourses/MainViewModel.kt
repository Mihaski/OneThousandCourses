package com.example.onethousandcourses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    fun refreshCourses() = viewModelScope.launch {


    }
}