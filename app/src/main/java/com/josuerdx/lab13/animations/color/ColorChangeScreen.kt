package com.josuerdx.lab13.animations.color

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.animation.core.tween
import com.josuerdx.lab13.viewmodel.ColorChangeViewModel

@Composable
fun ColorChangeScreen(viewModel: ColorChangeViewModel = viewModel()) {

    val color by animateColorAsState(
        targetValue = viewModel.currentColor.value,
        animationSpec = tween(durationMillis = 1000)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Botón para cambiar el color
        Button(onClick = { viewModel.toggleColor() }) {
            Text("Cambiar Color del Cuadro")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Cuadro con color de fondo animado
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color)
        )
    }
}