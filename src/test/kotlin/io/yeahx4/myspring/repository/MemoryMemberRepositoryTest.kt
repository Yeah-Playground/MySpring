package io.yeahx4.myspring.repository

import io.yeahx4.myspring.domain.Member
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MemoryMemberRepositoryTest {
    private val repository = MemoryMemberRepository()

    @AfterEach
    fun clearStore() {
        repository.clearStore()
    }

    @Test
    fun save() {
        val member = Member("spring")

        repository.save(member)
        val result = repository.findByMemberId(member.memberId).get()
        Assertions.assertEquals(result, member)
    }

    @Test
    fun findAll() {
        val member1 = Member("spring1")
        val member2 = Member("spring2")

        repository.save(member1)
        repository.save(member2)

        val result = repository.findAll()
        Assertions.assertEquals(result.size, 2)
    }
}
