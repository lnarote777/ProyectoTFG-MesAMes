package com.example.Api_Tfg.model

data class SubscriptionRequest(
    val email: String,
    val type: String // "mensual" o "unico"
)