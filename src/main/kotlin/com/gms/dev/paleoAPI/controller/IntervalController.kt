package com.gms.dev.paleoAPI.controller
import com.gms.dev.paleoAPI.entity.Interval
import com.gms.dev.paleoAPI.service.IntervalService
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
class IntervalController(@Qualifier("intervalService") private val intervalService:  IntervalService) {
//    @Qualifier("intervalController")
    var logger: Logger = LoggerFactory.getLogger(IntervalController::class.java)

    val service: IntervalService = intervalService

    @GetMapping("/intervals/test")
    fun testString(): ResponseEntity<String>
    {
        val str = "Intervals Test String"
        return ResponseEntity<String>(str, HttpStatus.OK)
    }

    @GetMapping("/interval/{id}")
    fun find(@PathVariable id: Long): ResponseEntity<Interval> {
        logger.debug("Call to find by id with id: $id")
        val interval = service.findById(id)
        if(interval === null) {
            logger.debug("No intervals found for intervalNo: $id")
            return ResponseEntity<Interval>(null,HttpStatus.NOT_FOUND)
        }
        return ResponseEntity<Interval>(interval, HttpStatus.OK)
    }
    @GetMapping("/intervals/list")
    fun getAll(

    ): ResponseEntity<List<Interval?>> {
        logger.debug("Getting all intervals")
        val intervals = service.findAll() as List<Interval?>
        //val intervals = service.findAll(page,sort) as List<Interval?>
        // var interval = new Interval();
        if(intervals.size === 0) {
            logger.debug("No intervals found")
            return ResponseEntity<List<Interval?>>(null,HttpStatus.NOT_FOUND)
        }
        return ResponseEntity<List<Interval?>>(intervals, HttpStatus.OK)
    }
//    @GetMapping("/intervals")
//    fun getAll(
//        @RequestParam sortBy:String="b_age",
//        @RequestParam sortDir:String="ASC",
//        @RequestParam page: Long = 0,
//        @RequestParam limit: Long = 25
//    ): ResponseEntity<List<Interval?>> {
//        logger.debug("Getting all intervals")
//        val sort = Sort.by(Sort.Direction.fromString("DESC"),"internalNo")
//        val start = page * limit.toInt()
//        val end = start + limit.toInt()
//        val page:Pageable = PageRequest.of(start.toInt(), end.toInt())
//        val intervals = service.findAll() as List<Interval?>
//        //val intervals = service.findAll(page,sort) as List<Interval?>
//        // var interval = new Interval();
//
//        return ResponseEntity<List<Interval?>>(intervals, HttpStatus.OK)
//    }

    @GetMapping("/intervals/count")
    fun count(): ResponseEntity<Long> {
        logger.debug("Getting all intervals")
        val count = service.count()
        return ResponseEntity<Long>(count, HttpStatus.OK)
    }
    @GetMapping("/interval/ages/{id}")
    fun getPeriodsByParentNo(@PathVariable id: Long): ResponseEntity<List<Interval>>{
        logger.debug("Getting intervals by parentNo for intervalNo: $id")
        val ages = service.getPeriodsByParentNo(id)
        if(ages === null || ages.size === 0) {
            logger.debug("No intervals found for intervalNo: $id")
            return ResponseEntity<List<Interval>>(null,HttpStatus.NOT_FOUND)
        }
        logger.debug("${ages.size} Intervals found for intervalNo: $id")
        return ResponseEntity<List<Interval>>(ages, HttpStatus.OK)
    }
    @GetMapping("/interval/periods/{intervalName}")
    fun getInterval(@PathVariable intervalName: String): ResponseEntity<List<Interval>>{
        logger.debug("Getting intervals by parentNo for intervalNo: $intervalName")
        val ages = service.getIntervalByName(intervalName)
        if(ages.size === 0) {
            logger.debug("No intervals found for intervalNo: $intervalName")
            return ResponseEntity<List<Interval>>(null,HttpStatus.NOT_FOUND)
        }
        return ResponseEntity<List<Interval>>(ages, HttpStatus.OK)
    }
    @GetMapping("/interval/children/{intervalName}")
    fun getIntervalsByParentName(@PathVariable parentIntervalName: String): ResponseEntity<List<Interval>>{
        logger.debug("Getting children Interval Name: $parentIntervalName")
        val intervals = service.getIntervalByName(parentIntervalName)
        if(intervals.size === 0) {
            logger.debug("No intervals found for parentIntervalName: $parentIntervalName")
            return ResponseEntity<List<Interval>>(null,HttpStatus.NOT_FOUND)
        }
        return ResponseEntity<List<Interval>>(intervals, HttpStatus.OK)
    }

//    @GetMapping("/ages/{name}")
//    fun getIntervalByIntervalNameSortOrderByBAge(
//            @RequestParam intervalNumber: Long,
//            @RequestParam sortBy:String="b_age",
//            @RequestParam sortDir:String="ASC"
//        ): ResponseEntity<List<Interval>>{
//        logger.debug("Getting intervals by type: $intervalNumber")
//        val sort = Sort.by(Sort.Direction.fromString(sortDir),sortBy)
//        val intervals = service.getIntervalByIntervalNameSortOrderByBAge(intervalNumber,sort)
//        if(intervals.size === 0) {
//            logger.debug("No intervals found for getIntervalByIntervalNameSortOrderByBAge: $intervalNumber")
//            return ResponseEntity<List<Interval>>(null,HttpStatus.NO_CONTENT)
//        }
//        return ResponseEntity<List<Interval>>(intervals, HttpStatus.OK)
//    }
}
