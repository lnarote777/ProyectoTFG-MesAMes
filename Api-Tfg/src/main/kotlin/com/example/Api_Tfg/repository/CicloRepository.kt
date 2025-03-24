package com.example.Api_Tfg.repository

import com.example.Api_Tfg.model.CicloMenstrual
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CicloRepository: MongoRepository<CicloMenstrual, Int> {
}