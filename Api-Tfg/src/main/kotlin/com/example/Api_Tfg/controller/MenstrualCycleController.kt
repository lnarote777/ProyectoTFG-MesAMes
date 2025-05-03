package com.example.Api_Tfg.controller

import com.example.Api_Tfg.model.MenstrualCycle
import com.example.Api_Tfg.service.MenstrualCycleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/cycles")
class MenstrualCycleController {
    @Autowired
    private lateinit var cycleService: MenstrualCycleService

    @PostMapping("/new")
    fun createCycle(){

    }

    @GetMapping("/user/{email}")
    fun getCyclesByUser(@PathVariable email: String): List<MenstrualCycle> {
        TODO()
        //return cycleService.getCyclesByUser(email)
    }
    /*
    @GetMapping("/{id}")
    fun getCycleById(@PathVariable id: String): MenstrualCycle? {
        return cycleService.getCycleById(id)
    }*/

    @PutMapping("/user/{email}")
    fun updateCycle(@PathVariable email: String, @RequestBody cycle: MenstrualCycle){

    }
}