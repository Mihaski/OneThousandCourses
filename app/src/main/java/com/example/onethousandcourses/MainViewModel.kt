package com.example.onethousandcourses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.GetListCoursesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getListCoursesUseCase: GetListCoursesUseCase,
) : ViewModel() {

    val uiState = getListCoursesUseCase.getListCoursesUseCase()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

}