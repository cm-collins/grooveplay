package com.example.grooveplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.grooveplay.feature.splash.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Entry point of the application.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        // Official SplashScreen API integration
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                splashViewModel.isOnboardingCompleted.value == null
            }
        }

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            GrooveplayApp(splashViewModel = splashViewModel)
        }
    }
}
