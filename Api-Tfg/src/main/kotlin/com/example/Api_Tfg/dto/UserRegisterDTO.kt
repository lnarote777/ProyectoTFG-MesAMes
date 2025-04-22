package com.example.Api_Tfg.dto

import com.example.Api_Tfg.model.Goal

data class UserRegisterDTO (
    val email: String,
    val username: String,
    val password: String,
    val passwordRepeat: String,
    val name: String,
    val birthDate: String,
    val goal: Goal = Goal.TRACK_PERIOD //por defecto, luego se cambia
)