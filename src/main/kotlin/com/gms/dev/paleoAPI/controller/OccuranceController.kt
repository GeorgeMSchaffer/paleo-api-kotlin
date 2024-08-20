package com.gms.dev.paleoAPI.controller
import com.gms.dev.paleoAPI.entity.Occurance
import com.gms.dev.paleoAPI.service.OccuranceService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/api")
//class IntervalController(@Qualifier("intervalService") private val intervalService:  IntervalService) {
class OccuranceController(@Qualifier("occuranceService") private val occuranceService: OccuranceService){
//    @Qualifier("occuranceController")
    var logger: Logger = LoggerFactory.getLogger(OccuranceController::class.java)

    val service: OccuranceService = occuranceService

    @GetMapping("/occurances/test")
    fun testString(): ResponseEntity<String>
    {
        val str = "Occurances Test String"
        return ResponseEntity<String>(str, HttpStatus.OK)
    }

//    @GetMapping("/occurances/interval/{intervalName}")
//    fun findOccurancesByIntervalName(@PathVariable intervalName: String): ResponseEntity<List<Occurance?>> {
//        logger.debug("Call to find by intervalName with intervalName: $intervalName")
//        val occurances = service.getOccurancesByEarlyInterval(intervalName)
//        return ResponseEntity<List<Occurance?>>(occurances, HttpStatus.OK)
//    }

    @GetMapping("/occurance/{id}")
    fun find(@PathVariable id: Long): ResponseEntity<Occurance> {
        logger.debug("Call to find by id with id: $id")
        val occurance = service.findById(id)
        return ResponseEntity<Occurance>(occurance, HttpStatus.OK)
    }
    @GetMapping("/occurance/family/{family}")
    fun findByFamily(@PathVariable family: String): ResponseEntity<List<Occurance>> {
        val occurances = service.findOccurancesByFamilyis(family)
        return ResponseEntity<List<Occurance>>(occurances, HttpStatus.OK)
    }
    @GetMapping("/occurance/family/{family}")
    fun findByGenus(@PathVariable family: String): ResponseEntity<List<Occurance>> {
        val occurances = service.findOccurancesByFamilyis(family)
        return ResponseEntity<List<Occurance>>(occurances, HttpStatus.OK)
    }
    @GetMapping("/occurance/class/{className}")
    fun findByClassName(@PathVariable className: String): ResponseEntity<List<Occurance>> {
        val occurances = service.findOccurancesByClassOrderIs(className)
        return ResponseEntity<List<Occurance>>(occurances, HttpStatus.OK)
    }
    @GetMapping("/occurances")
    fun getAll(

    ): ResponseEntity<List<Occurance?>> {
        logger.debug("Getting all occurances")
        val occurances = service.findAll() as List<Occurance?>
        //val occurances = service.findAll(page,sort) as List<Occurance?>
        // var occurance = new Occurance();

        return ResponseEntity<List<Occurance?>>(occurances, HttpStatus.OK)
    }
}