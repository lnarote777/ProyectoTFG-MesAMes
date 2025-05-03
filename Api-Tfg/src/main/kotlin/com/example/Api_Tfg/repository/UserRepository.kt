package com.example.Api_Tfg.repository

import com.example.Api_Tfg.model.UserEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: MongoRepository<UserEntity, String> {
    fun findUserBy_id(email: String): Optional<UserEntity>
    fun findByUsername(username: String): Optional<UserEntity>
}