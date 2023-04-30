package io.yeahx4.myspring.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "Member")
data class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var memberId: Long,

    @Column(name = "name") val memberName: String
) {
    fun setId(id: Long) {
        this.memberId = id
    }

    constructor(name: String) : this(-1, name)
    constructor() : this("unknown")
}
