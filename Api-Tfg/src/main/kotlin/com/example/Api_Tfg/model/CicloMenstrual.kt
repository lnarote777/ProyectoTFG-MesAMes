package com.example.Api_Tfg.model

import java.util.Date

data class CicloMenstrual(
    val _id : Int, //Auto incremental
    val user: Usuario,
    val fechaInicio : Date,
    val fechaFin : Date,
    val duracion : Int,
    val flujo: String, // enum FLUJO // ligero / moderado / abundante / coágulos
    val notas: String
)

enum class Flujo {
    LIGERO, MODERADO, ABUNDANTE, COAG // Coagulos
}
