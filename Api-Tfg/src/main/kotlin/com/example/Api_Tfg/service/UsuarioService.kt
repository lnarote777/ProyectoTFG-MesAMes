package com.example.Api_Tfg.service

import com.example.Api_Tfg.dto.DTOMapper
import com.example.Api_Tfg.dto.UsuarioDTO
import com.example.Api_Tfg.dto.UsuarioRegistroDTO
import com.example.Api_Tfg.error.exception.BadRequestException
import com.example.Api_Tfg.error.exception.UnauthorizedException
import com.example.Api_Tfg.error.exception.UserExistException
import com.example.Api_Tfg.model.Usuario
import com.example.Api_Tfg.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService: UserDetailsService {
    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @Autowired
    private lateinit var usuarioRepository: UsuarioRepository

    override fun loadUserByUsername(username: String?): UserDetails {
        val usuario: Usuario = usuarioRepository
            .findByUsername(username!!)
            .orElseThrow {
                UnauthorizedException("$username-+ no existente")
            }

        return User.builder()
            .username(usuario.username)
            .password(usuario.password)
            .build()
    }

    fun insertarUsuario(usuarioRegistro: UsuarioRegistroDTO): UsuarioDTO {
        val exist = usuarioRepository.findUserBy_id(usuarioRegistro.email)
        if (exist.isPresent) {
            throw UserExistException("Usuario existente.")
        }

        comprobarCredenciales(usuarioRegistro)

        val usuario = DTOMapper.userDTOToEntity(usuarioRegistro)
        usuarioRepository.insert(usuario)
        val usuarioDTO = DTOMapper.userEntityToDTO(usuario)

        return usuarioDTO
    }


    private fun comprobarCredenciales(usuario: UsuarioRegistroDTO){
        if (usuario.email.isBlank() || !usuario.email.contains("@")) throw BadRequestException("Formato de email inválido")
        if (usuario.password.isBlank() || usuario.password.length < 6 ) throw BadRequestException("Formato de password inválido.")
        if (usuario.nombre.isBlank()) throw BadRequestException("Formato de nombre inválido.")
        if (usuario.passwordRepeat.isBlank() || usuario.password != usuario.passwordRepeat) throw BadRequestException("Las contraseñas no coinciden.")
        if (usuario.peso < 0) throw BadRequestException("El peso(Kg) debe ser un valor positivo.")
        if (usuario.altura < 0) throw BadRequestException("La altura(cm) debe ser un valor positivo.")
        if (!usuario.fechaNacimiento.matches(Regex("""\d{4}-\d{2}-\d{2}"""))) throw BadRequestException("Formato de fecha inválido. Debe ser YYYY-MM-DD.")
    }

}