package com.josuerdx.lab13.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

sealed class ContentState {
    object Loading : ContentState()
    object Content : ContentState()
    object Error : ContentState()
}

class ContentStateViewModel : ViewModel() {

    val contentState = mutableStateOf<ContentState>(ContentState.Loading)

    // Cambia el estado de la pantalla
    fun changeState() {
        contentState.value = when (contentState.value) {
            is ContentState.Loading -> ContentState.Content
            is ContentState.Content -> ContentState.Error
            is ContentState.Error -> ContentState.Loading
        }
    }
}