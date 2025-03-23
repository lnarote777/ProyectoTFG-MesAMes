package com.example.Api_Tfg.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date

@Document("Usuarios")
data class User (
    @Id
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