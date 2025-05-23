package com.example.Api_Tfg.repository

import com.example.Api_Tfg.model.DailyLog
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface DailyLogRepository: MongoRepository<DailyLog, String> {
    fun findByUserId(userId: String): List<DailyLog>
    fun findByUserIdAndDate(userId: String, date: LocalDate): DailyLog?
}