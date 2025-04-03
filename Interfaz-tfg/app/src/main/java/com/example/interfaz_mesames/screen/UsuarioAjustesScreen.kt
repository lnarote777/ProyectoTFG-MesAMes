package com.example.interfaz_mesames.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.interfaz_mesames.compose.Header
import com.example.interfaz_mesames.navigation.AppScreen

@Composable
fun UsuarioAjustesScreen(navController: NavController){
    Header(
        navController = navController,
        title = "Ajustes de usuario",
        back = false,
        route = AppScreen.UserScreen.route
    )
}