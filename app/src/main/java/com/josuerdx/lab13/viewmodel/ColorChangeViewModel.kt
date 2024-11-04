package com.josuerdx.lab13.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class ColorChangeViewModel : ViewModel() {

    val currentColor = mutableStateOf(Color.Blue)

    fun toggleColor() {
        currentColor.value = if (currentColor.value == Color.Blue) Color.Green else Color.Blue
    }
}