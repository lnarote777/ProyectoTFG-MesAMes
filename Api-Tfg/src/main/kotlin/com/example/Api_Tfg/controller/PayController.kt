package com.example.Api_Tfg.controller

import com.example.Api_Tfg.model.SubscriptionRequest
import com.stripe.Stripe
import com.stripe.model.checkout.Session
import com.stripe.param.checkout.SessionCreateParams
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/pay")
class PayController(
    @Value("\${stripe.secret.key}") private val stripeSecretKey: String,
    @Value("\${frontend.success.url}") private val successUrl: String,
    @Value("\${frontend.cancel.url}") private val cancelUrl: String
) {
    init {
        Stripe.apiKey = stripeSecretKey
    }
    @PostMapping("create-subscription")
    fun createSubscription(@RequestBody request: SubscriptionRequest): Map<String, String> {
        val (email, type) = request

        val priceId = when (type) {
            "monthly" -> "price_monthly_id" // ID de Stripe para suscripción mensual
            "one_time" -> "price_one_time_id" // ID de Stripe para pago único
            else -> throw IllegalArgumentException("Tipo de suscripción inválido")
        }

        val mode = when (type) {
            "monthly" -> SessionCreateParams.Mode.SUBSCRIPTION
            "one_time" -> SessionCreateParams.Mode.PAYMENT
            else -> throw IllegalArgumentException("Tipo de suscripción inválido")
        }

        val params = SessionCreateParams.builder()
            .setMode(mode)
            .setCustomerEmail(email)
            .setSuccessUrl(successUrl)
            .setCancelUrl(cancelUrl)
            .addLineItem(
                SessionCreateParams.LineItem.builder()
                    .setQuantity(1L)
                    .setPrice(priceId)
                    .build()
            )
            .build()

        val session = Session.create(params)
        return mapOf("url" to session.url)
    }

}

//https://tusitio.com/exito?session_id={CHECKOUT_SESSION_ID}  / https://tusitio.com/cancelado