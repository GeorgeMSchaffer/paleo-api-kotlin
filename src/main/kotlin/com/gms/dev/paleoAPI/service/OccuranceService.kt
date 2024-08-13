package com.gms.dev.paleoAPI.service

import com.gms.dev.paleoAPI.entity.Occurance

import com.gms.dev.paleoAPI.repository.OccuranceRepository
import io.micrometer.common.lang.NonNull
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties
import org.springframework.data.domain.Page
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service

class OccuranceService(@Qualifier("occuranceRepository") val repo: OccuranceRepository) {
    var logger: Logger = LoggerFactory.getLogger(OccuranceService::class.java)

    fun findAll(): List<Occurance?> {
        logger.debug("Calling occurance findAll")
        return repo.findAll() as List<Occurance?>
    }

//    @Qualifier("findAll")
//    open fun findAll(pageable: org.springframework.data.domain.Pageable,sort:Sort): Page<Occurance?> {
//        logger.debug("Calling occurance findAll")
//        return repo.findAll(pageable)
//    }

    fun getOccurancesByEarlyInterval(intervalName: String): List<Occurance> {
        logger.debug("Trying to get occurance by intervalName: $intervalName")
        return repo.findByInterval_Name(intervalName)
    }

    @NonNull
    fun findById(id: Long?): Occurance {
        logger.debug("Calling occurance FindById")
        return id?.let { repo.findById(it).get() } as Occurance
    }

    fun count(): Long {
        return repo.count()
    }

//    fun getOccuranceByOccuranceNameSortOrderByBAge(occuranceNo:Long,sort: Sort): List<Occurance> {
//        logger.debug("Trying to get occurance by occuranceNo: $occuranceNo and sort by: $sort")
//        return repo.getOccurancesByOccuranceNoOrderByBAge(occuranceNo,sort)
//    }
}
