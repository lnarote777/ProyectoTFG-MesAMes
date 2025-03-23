package com.example.Api_Tfg.model

import java.util.Date

data class User (
    val _id : String,
    val name : String,
    val username: String,
    val fechaNacimiento: Date,
    val fechaAlta: Date,
    val peso: Double,
    val altura: Double,
    val objetivo: Objetivo //String // Quedar enbarazada - evitar embarazo - seguimiento general
)

//Sujeto a cambio
enum class Objetivo {
    QUEDAR, EVITAR, GENERAL
}