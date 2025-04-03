package com.example.interfaz_mesames

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.interfaz_mesames.navigation.AppNavigation
import com.example.interfaz_mesames.ui.theme.InterfazMesAMesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InterfazMesAMesTheme {
                AppNavigation()
            }
        }
    }
}