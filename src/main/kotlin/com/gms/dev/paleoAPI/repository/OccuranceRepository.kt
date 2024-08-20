package com.gms.dev.paleoAPI.repository
import com.gms.dev.paleoAPI.entity.Occurance
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.repository.CrudRepository
import org.springframework.lang.NonNull
import java.util.*


open interface OccuranceRepository : CrudRepository<Occurance?, Long?>
//    , ListPagingAndSortingRepository<Interval?, Long?>
{
    @Qualifier("intervalRepository")
    @NonNull
    override fun findById(id: Long): Optional<Occurance?>

    //fun findById(id: Long?): Optional<Interval?>?
    @NonNull
    override fun findAll(): List<Occurance?> //public List<Interval> findByEraId(int eraId);
    fun findOccurancesByGenusIsOr(genus: String): List<Occurance>
    fun findOccurancesByGenusIs(genus:String):List<Occurance>
    fun findOccurancesByPhylumIs(phylum:String): List<Occurance>
    fun findOccurancesByClassOrderIs(classOrder:String): List<Occurance>
    fun findOccurancesByFamily(family:String): List<Occurance>
//fun findByInterval_Name(intervalName: String?): List<Occurance?>?
//    fun getOccurancesByEarlyInterval(earlyInterval: String): List<Occurance>
    //fun findByEarlyInterval_NameOrderByMinMa(earlyInterval: String?): List<Occurance?>
}