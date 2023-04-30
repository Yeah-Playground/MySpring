package io.yeahx4.myspring.repository

import io.yeahx4.myspring.domain.Member
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface MemberRepository {
    fun save(member: Member): Member
    fun findByMemberId(id: Long): Optional<Member>
    fun findByMemberName(name: String): Optional<Member>
    fun findAll(): List<Member>
}
