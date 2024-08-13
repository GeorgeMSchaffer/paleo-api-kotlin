package com.gms.dev.paleoAPI.repository

import com.gms.dev.paleoAPI.entity.Occurance
import jakarta.persistence.EntityManager
import jakarta.persistence.TypedQuery
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.transaction.annotation.Transactional
import java.util.*
import org.springframework.data.domain.Sort

//class OccuranceRepositoryImpl(val em: EntityManager) : OccuranceRepository {
abstract class OccuranceRepositoryImpl(val em: EntityManager) :  OccuranceRepository {
@Qualifier("occuranceRepositoryImpl")
//    override fun findById(id: Long): Optional<Occurance?> {
//        TODO("Not yet implemented")
//    }
override fun findById(id: Long): Optional<Occurance?> {
    if (id == null) {
        throw IllegalArgumentException("ID cannot be null")
    }
    val query: TypedQuery<Occurance> =
        em.createQuery("SELECT i FROM Occurance i where i.id = :id", Occurance::class.java)
    query.setParameter("id", id)
    val occurance = Optional.ofNullable(query.singleResult) as Optional<Occurance?>
//    return try {
    return occurance
}


//    @Transactional
//    open fun findAll(pageable: Pageable): Page<Occurance?> {
//        val cb = em.criteriaBuilder
//        val query = cb.createQuery(Occurance::class.java)
//        val root = query.from(Occurance::class.java)
//        query.select(root)
//
//        val typedQuery = em.createQuery(query)
//
//        //typedQuery.firstResult = pageable.pageNumber * pageable.pageSize
//        //typedQuery.maxResults = pageable.pageSize
//
//        return typedQuery.getResultList()  as Page<Occurance?>
//    }
//    data class Pageable(val pageNumber: Int, val pageSize: Int)

//override fun findById(id: Long): Optional<Occurance?> {
//    fun <T> Optional<T>.unwrap(): T? = orElse(null)
//
//    if (id == null) {
//        throw IllegalArgumentException("ID cannot be null")
//    }
//    val query: TypedQuery<Occurance> =
//        em.createQuery("SELECT i FROM Occurance i where i.id = :id", Occurance::class.java)
//    query.setParameter("id", id)
//        val occurance = Optional.ofNullable(query.singleResult) as Optional<Occurance?>
////    return try {
//    return occurance
//}



    //    override fun findById(id: Long?): Optional<Occurance?> {
//        if (id == null) {
//            return Optional.empty()
//        }
//
//        val query: TypedQuery<Occurance> =
//            em.createQuery("SELECT i FROM Occurance i where id = :id", Occurance::class.java)
//        query.setParameter("id", id)
//
//        return try {
//            Optional.ofNullable(query.singleResult)
//        } catch (ex: NoResultException) {
//            Optional.empty<Occurance>()
//        }
//    }
//    override fun findAll(): List<Occurance?> {
//        val query: TypedQuery<Occurance> =
//            em.createQuery("SELECT i FROM Occurance i", Occurance::class.java)
//        return query.resultList
//    }

    override fun <S : Occurance?> save(entity: S & Any): S & Any {
        TODO("Not yet implemented")
    }

    override fun <S : Occurance?> saveAll(entities: MutableIterable<S>): MutableIterable<S> {
        TODO("Not yet implemented")
    }

    override fun findAllById(ids: MutableIterable<Long?>): MutableIterable<Occurance?> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun delete(entity: Occurance) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<Long?>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<Occurance?>) {
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