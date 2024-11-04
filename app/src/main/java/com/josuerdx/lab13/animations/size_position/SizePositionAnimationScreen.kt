package com.josuerdx.lab13.animations.size_position

import androidx.compose.animation.core.animateDpAsState
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
import androidx.compose.ui.graphics.Color
import com.josuerdx.lab13.viewmodel.SizePositionAnimationViewModel

@Composable
fun SizePositionAnimationScreen(viewModel: SizePositionAnimationViewModel = viewModel()) {

    val animatedSize by animateDpAsState(targetValue = viewModel.boxSize.value, label = "")
    val animatedOffsetX by animateDpAsState(targetValue = viewModel.boxOffsetX.value, label = "")
    val animatedOffsetY by animateDpAsState(targetValue = viewModel.boxOffsetY.value, label = "")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Botón para cambiar tamaño y posición
        Button(onClick = { viewModel.toggleSizePosition() }) {
            Text("Mover y Cambiar Tamaño")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Cuadro con tamaño y posición animados
        Box(
            modifier = Modifier
                .size(animatedSize)
                .offset(x = animatedOffsetX, y = animatedOffsetY)
                .background(Color.Magenta)
        )
    }
}