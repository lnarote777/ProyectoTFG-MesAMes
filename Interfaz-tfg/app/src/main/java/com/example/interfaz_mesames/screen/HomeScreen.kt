package com.example.interfaz_mesames.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.interfaz_mesames.R
import com.example.interfaz_mesames.compose.Footer
import com.example.interfaz_mesames.compose.Header
import com.example.interfaz_mesames.compose.calendario.Mes
import com.example.interfaz_mesames.navigation.AppScreen
import kotlinx.coroutines.delay
import java.time.LocalDate
import java.util.Date


@Composable
fun HomeScreen(navController: NavController){
    val diasPeriodo = 7 //cambiar
    val scrollState = rememberScrollState()
    LaunchedEffect(Unit) {
        scrollState.scrollTo(0)
    }
    LaunchedEffect(scrollState.value) {
        if (scrollState.value == scrollState.maxValue) {
            navController.navigate(route = AppScreen.DailyScreen.route)
        }
    }


    Box(modifier = Modifier.padding(top = 30.dp)) {
        Image(
            painter = painterResource(R.drawable.tema_claro),
            contentDescription = "Fondo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxSize()
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp) // Deja espacio para el footer
            .verticalScroll(scrollState)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp, vertical = 30.dp)
            ) {
                IconButton(
                    onClick = { navController.navigate(route = AppScreen.PremiumScreen.route) },
                    modifier = Modifier.size(50.dp) // Aquí defines el tamaño real del botón
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(R.drawable.corona_home),
                            contentDescription = "VIP",
                            modifier = Modifier.fillMaxSize() // La imagen se escala al tamaño del contenedor
                        )
                    }
                }
                Spacer(Modifier.weight(1f))

                IconButton(
                    onClick = {navController.navigate(route = AppScreen.UserScreen.route)}
                ) {
                    Image(painter = painterResource(R.drawable.user_icon),
                        contentDescription = "VIP",
                        modifier = Modifier.size(35.dp)
                    )
                }
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(270.dp)
                        .clip(CircleShape)
                        .background(colorResource(R.color.rosa_55))
                        .border(
                            width = 20.dp,
                            color = colorResource(R.color.bordeMorado),
                            shape = CircleShape
                        )
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        Text("$diasPeriodo") // cambiar segun lo de la api
                        Text("Dias hasta el próx. período")
                    }
                }
                Spacer(Modifier.height(70.dp))
                val currentDate = LocalDate.now()
                var selectedDate by remember { mutableStateOf(LocalDate.now()) }
                Mes(
                    year = currentDate.year,
                    month = currentDate.month,
                    selectedDate = selectedDate,
                    currentDate = currentDate
                ) { date -> selectedDate = date }
                Spacer(Modifier.height(100.dp))
            }
        }

        Footer(navController = navController,
        modifier = Modifier
            .align(alignment = Alignment.BottomCenter)
            .padding(vertical = 18.dp) )
    }
}