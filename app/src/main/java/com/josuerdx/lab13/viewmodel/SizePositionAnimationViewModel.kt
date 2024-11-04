package com.josuerdx.lab13.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

class SizePositionAnimationViewModel : ViewModel() {

    val boxSize = mutableStateOf(100.dp)
    val boxOffsetX = mutableStateOf(0.dp)
    val boxOffsetY = mutableStateOf(0.dp)

    // Alterna el tamaño y posición del cuadro
    fun toggleSizePosition() {

        if (boxSize.value == 100.dp) {
            boxSize.value = 150.dp
            boxOffsetX.value = 50.dp
            boxOffsetY.value = 50.dp
        } else {
            boxSize.value = 100.dp
            boxOffsetX.value = 0.dp
            boxOffsetY.value = 0.dp
        }
    }
}