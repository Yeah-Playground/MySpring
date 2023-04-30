package io.yeahx4.myspring.repository

import io.yeahx4.myspring.domain.Member
import jakarta.persistence.EntityManager
import java.util.Optional

class JpaMemberRepository(private val em: EntityManager): MemberRepository {
    override fun save(member: Member): Member {
        em.persist(member)
        return member
    }

    override fun findByMemberId(id: Long): Optional<Member> {
        val member = em.find(Member::class.java, id)
        return Optional.ofNullable(member)
    }

    override fun findByMemberName(name: String): Optional<Member> {
        val result = em
            .createQuery("select m FROM Member AS m WHERE m.memberName = :name", Member::class.java)
            .setParameter("name", name)
            .resultList

        return result.stream().findAny()
    }

    override fun findAll(): List<Member> {
        return em
            .createQuery("SELECT m FROM Member AS m", Member::class.java)
            .resultList
    }
}
