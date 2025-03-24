package com.example.Api_Tfg.error.exception

class UnauthorizedException(message: String) : Exception("Not authorized exception (401). $message") {
}