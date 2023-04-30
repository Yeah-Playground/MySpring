package io.yeahx4.myspring.repository

import io.yeahx4.myspring.domain.Member
import java.util.*
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataJpaMemberRepository:
    JpaRepository<Member, Long>,
    MemberRepository
{
    override fun findByMemberName(name: String): Optional<Member>
}
