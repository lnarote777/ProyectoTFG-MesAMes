package com.example.Api_Tfg.model

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document("DailyLog")
data class DailyLog(
    val id: String? = null,                  // MongoDB-generated ID
    val userId: String,                      // User reference
    val date: LocalDate,                     // Day of the log
    val hasBleeding: Boolean = false,        // Is there bleeding today?
    val flow: FlowLevel? = null,             // Flow level (if any)
    val symptoms: List<String> = listOf(),   // Symptoms reported
    val mood: String? = null,                // Mood of the day
    val hadSex: Boolean = false,             // Sexual activity
    val notes: String? = null                // Optional free text
)