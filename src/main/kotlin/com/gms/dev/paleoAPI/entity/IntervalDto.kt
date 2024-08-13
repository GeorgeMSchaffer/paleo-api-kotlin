package com.gms.dev.paleoAPI.entity

import java.io.Serializable

/**
 * DTO for {@link com.gms.dev.paleoAPI.entity.Interval}
 */
data class IntervalDto(
    val recordType: String? = null,
    val scaleNo: Long? = null,
    val intervalName: String? = null,
    val earlyOccurance: OccuranceDto? = null,
    val abbrev: String? = null,
    val parentNo: Long? = null,
    val color: String? = null,
    val tAge: Long? = null,
    val bAge: Double? = null,
    val referenceNo: Long? = null
) : Serializable {
    /**
     * DTO for {@link com.gms.dev.paleoAPI.entity.Occurance}
     */
    data class OccuranceDto(
        val occurrenceNo: Int? = null,
        val recordType: String? = null,
        val reidNo: String? = null,
        val flags: String? = null,
        val collectionNo: Int? = null,
        val identifiedName: String? = null,
        val identifiedRank: String? = null,
        val identifiedNo: Int? = null,
        val difference: String? = null,
        val acceptedName: String? = null,
        val acceptedRank: String? = null,
        val acceptedNo: Int? = null,
        val maxMa: Double? = null,
        val minMa: Double? = null,
        val referenceNo: Int? = null,
        val cc: String? = null,
        val state: String? = null,
        val county: String? = null,
        val latlngBasis: String? = null,
        val latlngPrecision: String? = null,
        val geogscale: String? = null,
        val geogcomments: String? = null,
        val phylum: String? = null,
        val classField: String? = null,
        val classOrder: String? = null,
        val family: String? = null,
        val genus: String? = null
    ) : Serializable
}