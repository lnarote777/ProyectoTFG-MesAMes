package com.example.Api_Tfg.error.exception

class BadRequestException(message: String) : Exception("Bad Request Exception (400). $message") {
}