package com.example.Api_Tfg.error.exception

class NotFoundException  (message: String) : Exception("Not Found (404). $message") {
}