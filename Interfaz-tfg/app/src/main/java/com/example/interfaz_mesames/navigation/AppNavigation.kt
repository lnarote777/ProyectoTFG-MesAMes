package com.example.interfaz_mesames.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.interfaz_mesames.screen.CalendarScreen
import com.example.interfaz_mesames.screen.config.CicloAjustesScreen
import com.example.interfaz_mesames.screen.config.ConfiguracionScreen
import com.example.interfaz_mesames.screen.DailyScreen
import com.example.interfaz_mesames.screen.HomeScreen
import com.example.interfaz_mesames.screen.LoadScreen
import com.example.interfaz_mesames.screen.LoginScreen
import com.example.interfaz_mesames.screen.PortadaScreen
import com.example.interfaz_mesames.screen.PremiumScreen
import com.example.interfaz_mesames.screen.RegistroScreen
import com.example.interfaz_mesames.screen.StatsScreen
import com.example.interfaz_mesames.screen.UserScreen
import com.example.interfaz_mesames.screen.config.UsuarioAjustesScreen


@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.UserScreen.route){
        composable(AppScreen.PortadaScreen.route){
            PortadaScreen(navController)
        }

        composable(AppScreen.LoginScreen.route){
            LoginScreen(navController)
        }

        composable(AppScreen.RegistroScreen.route){
            RegistroScreen(navController)
        }

        composable(AppScreen.CalendarScreen.route){
            CalendarScreen(navController)
        }

        composable(AppScreen.ConfiguracionScreen.route){
            ConfiguracionScreen(navController)
        }

        composable(AppScreen.DailyScreen.route){
            DailyScreen(navController)
        }

        composable(AppScreen.HomeScreen.route){
            HomeScreen(navController)
        }

        composable(AppScreen.LoadScreen.route){
            LoadScreen(navController)
        }

        composable(AppScreen.PremiumScreen.route){
            PremiumScreen(navController)
        }

        composable(AppScreen.UserScreen.route){
            UserScreen(navController)
        }

        composable(AppScreen.UsuarioAjustesScreen.route+ "/{username}/{email}",
            arguments = listOf(
                navArgument(name = "username"){
                    type = NavType.StringType
                },
                navArgument(name = "email"){
                    type = NavType.StringType
                }
            )
        ){
            UsuarioAjustesScreen(
                navController,
                username = it.arguments?.getString("username")?: "",
                email = it.arguments?.getString("email")?: ""
            )
        }

        composable(AppScreen.StatsScreen.route){
            StatsScreen(navController)
        }

        composable(AppScreen.CicloAjustesScreen.route){
            CicloAjustesScreen(navController)
        }


/*
        composable(AppScreen.HomeScreen.route + "/{user}/{userRol}/{token}",
            arguments = listOf(
                navArgument(name = "user"){
                type = NavType.StringType
                },
                navArgument(name = "userRol"){
                type = NavType.StringType
                },
                navArgument(name = "token") {
                type = NavType.StringType
                }
            )
        ){
            HomeScreen(
                navController = navController,
                user = it.arguments?.getString("user"),
                token = it.arguments?.getString("token") ?: "",
                userRol = it.arguments?.getString("userRol")
            )
        }
*/

    }
}
