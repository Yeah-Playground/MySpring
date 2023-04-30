package io.yeahx4.myspring.repository

import io.yeahx4.myspring.domain.Member
import java.util.*

class MemoryMemberRepository: MemberRepository {
    companion object {
        private var store = mutableMapOf<Long, Member>()
        private var sequence = 0L
    }

    override fun save(member: Member): Member {
        member.setId(++sequence)
        store[member.memberId] = member
        return member
    }

    override fun findByMemberId(id: Long): Optional<Member> {
        return Optional.ofNullable(store[id])
    }

    override fun findByMemberName(name: String): Optional<Member> {
        return store.values.stream().filter {
            it.memberName === name
        }.findAny()
    }

    override fun findAll(): List<Member> {
        return store.values.toList()
    }

    fun clearStore() {
        store.clear()
    }
}
