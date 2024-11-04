package com.josuerdx.lab13.animations.combined

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.josuerdx.lab13.viewmodel.CombinedAnimationsViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CombinedAnimationsScreen(viewModel: CombinedAnimationsViewModel = viewModel()) {

    val animatedSize by animateDpAsState(targetValue = viewModel.boxSize.value, animationSpec = tween(600))
    val animatedColor by animateColorAsState(targetValue = viewModel.boxColor.value, animationSpec = tween(600))
    val scope = rememberCoroutineScope()

    // Column para organizar
    AnimatedContent(
        targetState = viewModel.isLightMode.value,
        transitionSpec = {
            fadeIn(animationSpec = tween(500)) with fadeOut(animationSpec = tween(500))
        }
    ) { isLightMode ->
        val backgroundColor = if (isLightMode) Color.White else Color.Black
        val textColor = if (isLightMode) Color.Black else Color.White

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Elemento que cambia de tamaño y color
            Box(
                modifier = Modifier
                    .size(animatedSize)
                    .background(animatedColor)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para cambiar el tamaño y color
            Button(onClick = { viewModel.toggleSizeColor() }) {
                Text("Cambiar Tamaño y Color", color = textColor)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para desaparecer y reaparecer
            AnimatedVisibility(
                visible = viewModel.buttonVisible.value,
                enter = slideInHorizontally() + fadeIn(animationSpec = tween(100)),
                exit = slideOutHorizontally() + fadeOut(animationSpec = tween(100))
            ) {
                Button(
                    onClick = {
                        viewModel.toggleButtonVisibility()
                        scope.launch {
                            delay(5000)
                            viewModel.toggleButtonVisibility()
                        }
                    },
                    modifier = Modifier.offset(x = 0.dp, y = 20.dp)
                ) {
                    Text("Desplazar y Ocultar Botón", color = textColor)
                }
            }

            Spacer(modifier = Modifier.height(60.dp))

            // Botón para alternar entre modo claro y oscuro
            Button(onClick = { viewModel.toggleContentMode() }) {
                Text(
                    if (isLightMode) "Cambiar a Modo Oscuro" else "Cambiar a Modo Claro",
                    color = textColor
                )
            }
        }
    }
}

