package com.example.Api_Tfg.error.exception

class UserExistException (message: String) : Exception("User Exist (400). $message") {
}