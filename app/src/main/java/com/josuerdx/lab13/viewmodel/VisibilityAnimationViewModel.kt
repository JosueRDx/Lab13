package com.josuerdx.lab13.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class VisibilityAnimationViewModel : ViewModel() {

    val isVisible = mutableStateOf(false)

    fun toggleVisibility() {
        isVisible.value = !isVisible.value
    }
}
