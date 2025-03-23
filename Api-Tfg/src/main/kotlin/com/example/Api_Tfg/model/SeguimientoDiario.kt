package com.example.Api_Tfg.model

import com.mongodb.internal.connection.Time
import java.util.Date

data class SeguimientoDiario(
    val _id: Int, //Auto Incremental
    val usuario: User,
    val horasSueno: Time,
    val fecha: Date,
    val flujo: Flujo, //string
    val actividad: String,
    val energia: String,
    val sintomas: String,
    val sentimientos: String,
    val notas: String
)
