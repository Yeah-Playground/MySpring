package io.yeahx4.myspring.service

import io.yeahx4.myspring.domain.Member
import io.yeahx4.myspring.repository.MemoryMemberRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MemberServiceTest {
    private var memberRepository = MemoryMemberRepository()
    private var memberService = MemberService(memberRepository)

    @AfterEach
    fun afterEach() {
        memberRepository = MemoryMemberRepository()
        memberService = MemberService(memberRepository)
    }

    @Test
    fun join() {
        val member = Member("hello")

        val saveId = memberService.join(member)
        val foundMember = memberService.findOne(saveId).get()

        assertEquals(member.memberName, foundMember.memberName)
    }

    @Test
    fun duplicateUserException() {
        val member1 = Member("spring")
        val member2 = Member("spring")

        val exception = org.junit.jupiter.api.assertThrows<IllegalStateException> {
            memberService.join(member1)
            memberService.join(member2)
        }

        assertEquals(exception.message, "User already exists.")
    }

    @Test
    fun findMembers() {

    }

    @Test
    fun findOne() {

    }
}
