package com.example.Api_Tfg.controller

import com.example.Api_Tfg.dto.UsuarioDTO
import com.example.Api_Tfg.dto.UsuarioLoginDTO
import com.example.Api_Tfg.dto.UsuarioRegistroDTO
import com.example.Api_Tfg.error.exception.BadRequestException
import com.example.Api_Tfg.error.exception.UnauthorizedException
import com.example.Api_Tfg.service.TokenService
import com.example.Api_Tfg.service.UsuarioService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/usuarios")
class UsuarioController {

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager
    @Autowired
    private lateinit var tokenService: TokenService
    @Autowired
    private lateinit var usuarioService: UsuarioService

    @PostMapping("/login")
    fun login(@RequestBody usuario: UsuarioLoginDTO?) : ResponseEntity<Any>? {
        if(usuario == null){
            throw BadRequestException("El parámetro no puede estar vacío.")
        }

        val authentication: Authentication = try {
            authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(usuario.username, usuario.password)
            )
        } catch (e: AuthenticationException) {
            throw UnauthorizedException("Credenciales incorrectas")
        }

        val token = tokenService.generarToken(authentication)
        return ResponseEntity(mapOf("token" to token), HttpStatus.OK)
    }

    @PostMapping("/register")
    fun insert(
        httpRequest: HttpServletRequest,
        @RequestBody usuarioInsertDTO: UsuarioRegistroDTO
    ) : ResponseEntity<UsuarioDTO>{
        val usuario = usuarioService.insertarUsuario(usuarioInsertDTO)
        return ResponseEntity(usuario, HttpStatus.CREATED)
    }

    @GetMapping("/lista")
    fun getAllUsers(
        httpRequest: HttpServletRequest
    ): ResponseEntity<List<UsuarioDTO>> {
        TODO()
    }

    @DeleteMapping("/delete/{email}")
    fun deleteByEmail(
        @PathVariable email: String,
        httpRequest: HttpServletRequest
    ) : ResponseEntity<UsuarioDTO>? {
        TODO()
    }

    @PutMapping("/update")
    fun update(
        @RequestBody usuarioUpdated: UsuarioRegistroDTO,
        httpRequest: HttpServletRequest,
    ): ResponseEntity<UsuarioDTO>{
        TODO()
    }

}