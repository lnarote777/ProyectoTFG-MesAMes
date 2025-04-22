package com.example.Api_Tfg.repository

import com.example.Api_Tfg.model.Usuario
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: MongoRepository<Usuario, String> {
    fun findUserBy_id(email: String): Optional<Usuario>
    fun findByUsername(username: String): Optional<Usuario>
}