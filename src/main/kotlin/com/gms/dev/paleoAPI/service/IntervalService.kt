package com.gms.dev.paleoAPI.service

import com.gms.dev.paleoAPI.entity.Interval

import com.gms.dev.paleoAPI.repository.IntervalRepository
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

class IntervalService(@Qualifier("intervalRepository") val repo: IntervalRepository) {
    var logger: Logger = LoggerFactory.getLogger(IntervalService::class.java)

    fun findAll(): List<Interval?> {
        logger.debug("Calling interval findAll")
        return repo.findAll() as List<Interval?>
    }

//    @Qualifier("findAll")
//    open fun findAll(pageable: org.springframework.data.domain.Pageable,sort:Sort): Page<Interval?> {
//        logger.debug("Calling interval findAll")
//        return repo.findAll(pageable)
//    }

    @NonNull
    fun findById(id: Long?): Interval {
        logger.debug("Calling interval FindById")
        return id?.let { repo.findById(it).get() } as Interval
    }

    fun count(): Long {
        return repo.count()
    }

    fun getPeriodsByParentNo(id: Long): List<Interval> {
        logger.debug("Trying to get interval by parentNo for intervalNo: $id")
        val child: Interval = findById(id)
        if (child == null) return emptyList()

        val parent = repo.getPeriodsByParentNo(id)
        logger.debug("Parent interval for intervalNo: $id is: $parent")
        if(parent == null) return emptyList()
        return parent as List<Interval>

    }

    fun getIntervalByName(name: String): List<Interval> {
        logger.debug("Trying to get interval by name: $name")
        return repo.getIntervalsByIntervalName(name)
    }
    fun getIntervalByType(name: String): List<Interval> {
        logger.debug("Trying to get interval by type: $name")
        return repo.getIntervalByType(name)
    }
//    fun getIntervalByIntervalNameSortOrderByBAge(intervalNo:Long,sort: Sort): List<Interval> {
//        logger.debug("Trying to get interval by intervalNo: $intervalNo and sort by: $sort")
//        return repo.getIntervalsByIntervalNoOrderByBAge(intervalNo,sort)
//    }
}
