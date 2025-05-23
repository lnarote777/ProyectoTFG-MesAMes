package com.example.Api_Tfg.dto

import com.example.Api_Tfg.model.UserEntity
import java.time.Instant
import java.util.*

object DTOMapper {

    fun userDTOToEntity(userDTO: UserRegisterDTO): UserEntity{
        return UserEntity(
            _id = userDTO.email,
            name = userDTO.name,
            username = userDTO.username,
            password = userDTO.password,
            birthDate = userDTO.birthDate,
            goal = userDTO.goal,
            roles = "USER",
            weight = 0.0,
            height = 0.0,
            registrationDate = Date.from(Instant.now())
        )
    }

    fun userEntityToDTO(user: UserEntity): UserDTO{
        return UserDTO(
            email = user._id,
            username = user.username,
            name = user.name
        )
    }

}