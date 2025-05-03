package com.example.Api_Tfg.dto

import com.example.Api_Tfg.model.Goal

data class UserUpdateDTO (
    val email: String,
    val name: String,
    var username: String,
    var password: String,
    var weight: Double,
    var height: Double,
    var goal: Goal
)
