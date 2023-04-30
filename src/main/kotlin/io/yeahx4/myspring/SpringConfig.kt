package io.yeahx4.myspring

import io.yeahx4.myspring.repository.MemberRepository
import io.yeahx4.myspring.service.MemberService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfig(
    private val memberRepository: MemberRepository
) {
    @Bean
    fun memberService() = MemberService(memberRepository)
}
