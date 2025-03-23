package com.example.Api_Tfg.model

import java.util.Date

data class Prediccion(
    val _id : Int,
    val usuario : User,
    val fechaInicio : Date,
    val fechaFinal : Date,
    val exactitud: Double //porcentaje
)
