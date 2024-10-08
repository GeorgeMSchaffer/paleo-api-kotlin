package com.gms.dev.paleoAPI.entity
import jakarta.persistence.*
import lombok.Getter
import lombok.Setter
import com.gms.dev.paleoAPI.entity.Interval

@Entity
@Getter
@Setter
@Table(name = "occurances")
@NamedQuery(
    name="occurance.getOccurancesByEarlyIntervalName",
    query = "FROM Occurance o inner join Interval i on i.intervalName = o.earlyInterval")

@NamedQuery(
    name="occurance.getGenonologyBetweenMya",
    query = "SELECT family,genus,classOrder,phylum,classField ,count(1) from Occurance WHERE minMa BETWEEN :myaStart and :myaEnd group by family,genus,classOrder,classField order by count(1) desc")

class Occurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "occurrence_no", nullable = false)
    private var occurrenceNo: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interval_no")
    private val intervalNo: Interval? = null


    @Column(name = "record_type")
    private var recordType: String? = null

    @Column(name = "reid_no")
    private var reidNo: String? = null

    @Column(name = "flags")
    private var flags: String? = null

    @Column(name = "collection_no")
    private var collectionNo: Int? = null

    @Column(name = "identified_name")
    private var identifiedName: String? = null

    @Column(name = "identified_rank")
    private var identifiedRank: String? = null

    @Column(name = "early_interval")
    private var earlyInterval: String? = null

    @Column(name = "late_interval")
    private var lateInterval: String? = null

    @Column(name = "identified_no")
    private var identifiedNo: Int? = null

    @Column(name = "difference")
    private var difference: String? = null

    @Column(name = "accepted_name")
    private var acceptedName: String? = null

    @Column(name = "accepted_rank")
    private var acceptedRank: String? = null

//    @Id
//    @Column(name = "accepted_no", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@ManyToOne
//
//    @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "interval_no")
//    private val interval: Interval? = null


    @Column(name = "max_ma")
    private var maxMa: Double? = null

    @Column(name = "min_ma")
    private var minMa: Double? = null

    @Column(name = "reference_no")
    private var referenceNo: Int? = null

    @Column(name = "cc")
    private var cc: String? = null

    @Column(name = "state")
    private var state: String? = null

    @Column(name = "county")
    private var county: String? = null

    @Column(name = "latlng_basis")
    private var latlngBasis: String? = null

    @Column(name = "latlng_precision")
    private var latlngPrecision: String? = null

    @Column(name = "geogscale")
    private var geogscale: String? = null

    @Column(name = "geogcomments")
    private var geogcomments: String? = null

    @Column(name = "phylum")
    private var phylum: String? = null

    @Column(name = "class")
    private var classField: String? = null

    @Column(name = "class_order")
    private var classOrder: String? = null

    @Column(name = "family")
    private var family: String? = null

    @Column(name = "genus")
    private var genus: String? = null
}