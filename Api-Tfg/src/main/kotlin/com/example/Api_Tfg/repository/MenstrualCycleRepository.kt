package com.example.Api_Tfg.repository

import com.example.Api_Tfg.model.MenstrualCycle
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MenstrualCycleRepository: MongoRepository<MenstrualCycle, Int> {
}