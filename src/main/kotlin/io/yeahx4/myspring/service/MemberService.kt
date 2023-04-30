package io.yeahx4.myspring.service

import io.yeahx4.myspring.domain.Member
import io.yeahx4.myspring.repository.MemberRepository
import java.util.Optional
import org.springframework.transaction.annotation.Transactional

@Transactional
class MemberService(private val memberRepository: MemberRepository) {
    private fun validateDuplicatedMember(member: Member) {
        memberRepository.findByMemberName(member.memberName)
            .ifPresent {
                throw IllegalStateException("User already exists.")
            }
    }

    fun join(member: Member): Long {
        validateDuplicatedMember(member)

        memberRepository.save(member)

        return member.memberId
    }

    fun findMembers(): List<Member> = memberRepository.findAll()

    fun findOne(id: Long): Optional<Member> = memberRepository.findByMemberId(id)
}
