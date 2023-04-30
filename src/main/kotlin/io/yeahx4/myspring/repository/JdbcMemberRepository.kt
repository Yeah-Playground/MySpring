package io.yeahx4.myspring.repository

import io.yeahx4.myspring.domain.Member
import java.util.Optional
import javax.sql.DataSource

class JdbcMemberRepository(private val dataSource: DataSource) : MemberRepository {
    override fun save(member: Member): Member {
        TODO("Not yet implemented")
    }

    override fun findByMemberId(id: Long): Optional<Member> {
        TODO("Not yet implemented")
    }

    override fun findByMemberName(name: String): Optional<Member> {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Member> {
        TODO("Not yet implemented")
    }
}
