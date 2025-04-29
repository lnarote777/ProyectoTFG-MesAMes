package com.example.Api_Tfg.repository

import com.example.Api_Tfg.model.DailyLog
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface DailyLogRepository: MongoRepository<DailyLog, Int> {
}