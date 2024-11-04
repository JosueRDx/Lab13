package com.josuerdx.lab13.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

class CombinedAnimationsViewModel : ViewModel() {
    // Estados para el tamaño y color del elemento
    val boxSize = mutableStateOf(100.dp)
    val boxColor = mutableStateOf(Color.Blue)

    // Estado para la visibilidad del botón
    val buttonVisible = mutableStateOf(true)

    // Estado para el modo claro/oscuro
    val isLightMode = mutableStateOf(true)

    // Alterna el tamaño y color del elemento
    fun toggleSizeColor() {
        boxSize.value = if (boxSize.value == 100.dp) 150.dp else 100.dp
        boxColor.value = if (boxColor.value == Color.Blue) Color.Green else Color.Blue
    }

    // Alterna la visibilidad del botón
    fun toggleButtonVisibility() {
        buttonVisible.value = !buttonVisible.value
    }

    // Alterna entre modo claro y oscuro
    fun toggleContentMode() {
        isLightMode.value = !isLightMode.value
    }
}