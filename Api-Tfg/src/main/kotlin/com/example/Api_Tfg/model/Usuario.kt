package com.example.Api_Tfg.model

import org.bson.codecs.pojo.annotations.BsonId
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date

@Document("Usuarios")
data class Usuario (
    @BsonId
    val _id : String, //email
    val name : String,
    val username: String,
    val password: String,
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