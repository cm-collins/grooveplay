package com.example.grooveplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.grooveplay.features.splash.viewmodel.SplashViewModel

/**
 * Entry point of the application.
 *
 * Adheres to:
 * - SOLID (Single Responsibility): Handles only Activity-level lifecycle and Splash integration.
 * - KISS: Manual dependency management for simplicity and performance.
 */
class MainActivity : ComponentActivity() {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        // Official SplashScreen API integration
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !splashViewModel.isReady.value
            }
        }

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            GrooveplayApp(splashViewModel = splashViewModel)
        }
    }
}
