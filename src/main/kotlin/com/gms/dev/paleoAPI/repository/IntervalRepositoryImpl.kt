package com.gms.dev.paleoAPI.repository

import com.gms.dev.paleoAPI.entity.Interval
import jakarta.persistence.EntityManager
import jakarta.persistence.TypedQuery
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.transaction.annotation.Transactional
import java.util.*
import org.springframework.data.domain.Sort

//class IntervalRepositoryImpl(val em: EntityManager) : IntervalRepository {
abstract class IntervalRepositoryImpl(val em: EntityManager) :  IntervalRepository {
@Qualifier("intervalRepositoryImpl")
//    override fun findById(id: Long): Optional<Interval?> {
//        TODO("Not yet implemented")
//    }
override fun findById(id: Long): Optional<Interval?> {
    if (id == null) {
        throw IllegalArgumentException("ID cannot be null")
    }
    val query: TypedQuery<Interval> =
        em.createQuery("SELECT i FROM Interval i where i.id = :id", Interval::class.java)
    query.setParameter("id", id)
    val interval = Optional.ofNullable(query.singleResult) as Optional<Interval?>
//    return try {
    return interval
}
    override fun getPeriodsByParentNo(parent: Long): List<Interval> {
        val query: TypedQuery<Interval> =
            em.createQuery("SELECT i FROM Interval i where i.parentNo = :parent", Interval::class.java)
        query.setParameter("parent", parent)
        return query.resultList
    }

//    @Transactional
//    open fun findAll(pageable: Pageable): Page<Interval?> {
//        val cb = em.criteriaBuilder
//        val query = cb.createQuery(Interval::class.java)
//        val root = query.from(Interval::class.java)
//        query.select(root)
//
//        val typedQuery = em.createQuery(query)
//
//        //typedQuery.firstResult = pageable.pageNumber * pageable.pageSize
//        //typedQuery.maxResults = pageable.pageSize
//
//        return typedQuery.getResultList()  as Page<Interval?>
//    }
//    data class Pageable(val pageNumber: Int, val pageSize: Int)

//override fun findById(id: Long): Optional<Interval?> {
//    fun <T> Optional<T>.unwrap(): T? = orElse(null)
//
//    if (id == null) {
//        throw IllegalArgumentException("ID cannot be null")
//    }
//    val query: TypedQuery<Interval> =
//        em.createQuery("SELECT i FROM Interval i where i.id = :id", Interval::class.java)
//    query.setParameter("id", id)
//        val interval = Optional.ofNullable(query.singleResult) as Optional<Interval?>
////    return try {
//    return interval
//}



    //    override fun findById(id: Long?): Optional<Interval?> {
//        if (id == null) {
//            return Optional.empty()
//        }
//
//        val query: TypedQuery<Interval> =
//            em.createQuery("SELECT i FROM Interval i where id = :id", Interval::class.java)
//        query.setParameter("id", id)
//
//        return try {
//            Optional.ofNullable(query.singleResult)
//        } catch (ex: NoResultException) {
//            Optional.empty<Interval>()
//        }
//    }
//    override fun findAll(): List<Interval?> {
//        val query: TypedQuery<Interval> =
//            em.createQuery("SELECT i FROM Interval i", Interval::class.java)
//        return query.resultList
//    }

    override fun <S : Interval?> save(entity: S & Any): S & Any {
        TODO("Not yet implemented")
    }

    override fun <S : Interval?> saveAll(entities: MutableIterable<S>): MutableIterable<S> {
        TODO("Not yet implemented")
    }

    override fun findAllById(ids: MutableIterable<Long?>): MutableIterable<Interval?> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun delete(entity: Interval) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<Long?>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<Interval?>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun existsById(id: Long): Boolean {
        TODO("Not yet implemented")
    }


}