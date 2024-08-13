package com.gms.dev.paleoAPI.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter
import com.gms.dev.paleoAPI.entity.Occurance

enum class IntervalTypeEnum {
    era,
    eon,
    period,
    epoch,
    age,
}
@Entity
@Table(name = "intervals")
@NamedQuery(name="interval.getIntervalHierarchy", query = "FROM Interval i inner join Interval i2 on i.id = i2.parentNo")
@Getter @Setter
public open class Interval {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interval_no", nullable = false)
    open var id: Long? = null



    @Column(name = "record_type")
    open var recordType: String? = null

    @Column(name = "scale_no")
    open var scaleNo: Long? = null

    @Column(name = "interval_name")
    open var intervalName: String? = null

    @OneToOne(mappedBy = "earlyInterval")
    @JoinColumn(name = "interval_name", referencedColumnName = "early_interval")
    private val earlyOccurance: Occurance? = null

    @Column(name = "abbrev")
    open var abbrev: String? = null

   // @Enumerated(EnumType.STRING)
    @Column(name = "type")
    open var type: String? = null

    @Column(name = "parent_no")
    open var parentNo: Long? = null

    @Column(name = "color")
    open var color: String? = null

    @Column(name = "t_age")
    open var tAge: Long? = null

    @Column(name = "b_age")
    open var bAge: Double? = null

    @Column(name = "reference_no")
    open var referenceNo: Long? = null

//    @JsonBackReference
//    @ManyToOne(cascade= [CascadeType.ALL])
//    @JoinColumn(name="parent_no")
//
//    private var parentInterval: Interval? = null
//    @OneToMany(mappedBy="parentInterval")
//    private var linkedInterval: MutableSet<Interval> = HashSet<Interval>()
//
//    fun getParentInterval(): Interval? {
//        return this.parentInterval
//    }
//
//    fun setParentInterval(parentInterval: Interval) {
//        this.parentInterval = parentInterval
//    }
//
//    fun getLinkedIntervals(): Set<Interval> {
//        return this.linkedInterval
//    }
//
//    fun setLinkedIntervals(linkedIntervals: Set<Interval?>) {
//        this.linkedInterval = linkedIntervals as MutableSet<Interval>
//    }
}