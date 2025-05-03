package com.example.Api_Tfg.security

import org.springframework.boot.context.properties.ConfigurationProperties
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey

@ConfigurationProperties(prefix = "rsa")
class RSAKeysProperties (
    var publicKey : RSAPublicKey,
    var privateKey: RSAPrivateKey
)
