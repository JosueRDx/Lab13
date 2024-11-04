package com.josuerdx.lab13.animations.content

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.josuerdx.lab13.viewmodel.ContentState
import com.josuerdx.lab13.viewmodel.ContentStateViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentScreen(viewModel: ContentStateViewModel = viewModel()) {
    val currentState by viewModel.contentState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Contenido animado según el estado actual
        AnimatedContent(
            targetState = currentState,
            transitionSpec = {
                fadeIn(animationSpec = tween(500)) with fadeOut(animationSpec = tween(500))
            }
        ) { state ->
            when (state) {
                is ContentState.Loading -> Text("Cargando...")
                is ContentState.Content -> Text("Contenido")
                is ContentState.Error -> Text("Error")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para alternar entre los estados
        Button(onClick = { viewModel.changeState() }) {
            Text("Cambiar Estado")
        }
    }
}