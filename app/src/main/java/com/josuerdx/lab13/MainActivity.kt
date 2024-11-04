package com.josuerdx.lab13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.josuerdx.lab13.animations.color.ColorChangeScreen
import com.josuerdx.lab13.animations.size_position.SizePositionAnimationScreen
import com.josuerdx.lab13.animations.visibility.VisibilityAnimationScreen
import com.josuerdx.lab13.ui.theme.Lab13Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            Lab13Theme {
                // Llamar a las pantallas
                // VisibilityAnimationScreen()
                // ColorChangeScreen()
                SizePositionAnimationScreen()
            }
        }
    }
}