package com.example.Api_Tfg.dto

import com.example.Api_Tfg.model.Objetivo
import java.util.Date

data class UsuarioRegistroDTO (
    val email: String,
    val username: String,
    val password: String,
    val passwordRepeat: String,
    val nombre: String,
    val fechaNacimiento: String,
    val peso: Double,
    val altura: Double,
    val objetivo: String //Objetivo
)