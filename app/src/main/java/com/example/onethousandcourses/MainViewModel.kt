package com.example.onethousandcourses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.GetListCoursesUseCase
import com.example.domain.ToggleLikeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getListCoursesUseCase: GetListCoursesUseCase,
    private val toggleLikeUseCase: ToggleLikeUseCase,
) : ViewModel() {

    val uiState = getListCoursesUseCase.getListCoursesUseCase()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun toggleLike(courseId: Int) {
        viewModelScope.launch {
            toggleLikeUseCase.toggle(courseId)
        }
    }
}