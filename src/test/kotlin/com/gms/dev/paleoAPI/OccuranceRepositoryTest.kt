package com.gms.dev.paleoAPI

import com.gms.dev.paleoAPI.entity.Occurance
import com.gms.dev.paleoAPI.repository.OccuranceRepository
import jakarta.annotation.Nullable
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.Optional
import java.util.*

class OccuranceRepositoryTest {

    private val occuranceRepository = Mockito.mock(OccuranceRepository::class.java)

    @Test
    fun testFindById() {
        // Given
        val occurance = Occurance()
        val id = 1L
        Mockito.`when`(occuranceRepository.findById(id)).thenReturn(Optional.of(occurance) as Optional<Occurance?>)

        // When
        val result = occuranceRepository.findById(id)

        // Then
        assertTrue(result.isPresent)
        assertEquals(occurance, result.get())
    }

    @Test
    fun testFindAll() {
        // Given
        val occurances = listOf(Occurance(), Occurance())
        Mockito.`when`(occuranceRepository.findAll()).thenReturn(occurances)

        // When
        val result = occuranceRepository.findAll()

        // Then
        assertEquals(occurances.size, result.size)
        assertEquals(occurances, result)
    }

    @Test
    fun testFindOccurancesByGenusIs() {
        // Given
        val genus = "Notocetus"
        val occurances = listOf(Occurance(), Occurance())
        System.out.println("Genus occurances: ${occurances.size}")
        Mockito.`when`(occuranceRepository.findOccurancesByGenusIs(genus)).thenReturn(occurances)

        // When
        val result = occuranceRepository.findOccurancesByGenusIs(genus)

        // Then
        assertEquals(occurances.size, result.size)
        assertEquals(occurances, result)
    }


    @Test
    fun testFindOccurancesByPhylumIs() {
        // Given
        val phylum = "permian"
        val occurances = listOf(Occurance(), Occurance())
        Mockito.`when`(occuranceRepository.findOccurancesByPhylumIs(phylum)).thenReturn(occurances)

        // When
        val result = occuranceRepository.findOccurancesByPhylumIs(phylum)
        System.out.println("found occurances: ${result.size}")
        // Then
        assertEquals(occurances.size, result.size)
        assertEquals(occurances, result)
    }

    @Test
    fun testFindOccurancesByClassOrderIsOr() {
        // Given
        val classOrder = "Cetacea"
        val occurances = listOf(Occurance(), Occurance())
        Mockito.`when`(occuranceRepository.findOccurancesByClassOrderIs(classOrder)).thenReturn(occurances)

        // When
        val result = occuranceRepository.findOccurancesByClassOrderIs(classOrder)

        // Then
        assertEquals(occurances.size, result.size)
        assertEquals(occurances, result)
    }

    @Test
    fun testFindOccurancesByFamilyis() {
        // Given
        val family = "Squaloziphiidae"
        val occurances = listOf(Occurance(), Occurance())
        Mockito.`when`(occuranceRepository.findOccurancesByFamilyis(family)).thenReturn(occurances)

        // When
        val result = occuranceRepository.findOccurancesByFamilyis(family)

        // Then
        assertEquals(occurances.size, result.size)
        assertEquals(occurances, result)
    }
}

