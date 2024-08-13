package com.gms.dev.paleoAPI.repository
import com.gms.dev.paleoAPI.entity.Interval
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.ListPagingAndSortingRepository
import org.springframework.lang.NonNull
import java.util.*
import org.springframework.data.domain.Sort

open interface IntervalRepository : CrudRepository<Interval?, Long?>
//    , ListPagingAndSortingRepository<Interval?, Long?>
{
@Qualifier("intervalRepository")
    @NonNull
    override fun findById(id: Long): Optional<Interval?>
    //fun findById(id: Long?): Optional<Interval?>?
    @NonNull
    override fun findAll(): List<Interval?> //public List<Interval> findByEraId(int eraId);
    fun getPeriodsByParentNo(parent: Long): List<Interval>
    fun getIntervalsByIntervalName(name: String): List<Interval>
    fun getIntervalByType(name: String): List<Interval>
    //fun sortByAgeStart(): List<Interval>
    //fun getIntervalsByIntervalNoOrderByBAge(intervalNo:Long,sort: Sort): List<Interval>
    //fun findAll(pageable: Pageable?,sort:Sort): Page<Interval?>?
    //public Optional<List<Interval>> findByAgeEnd(String ageEnd);
    //public List<Interval> findByAgeStart(String ageStart);
}