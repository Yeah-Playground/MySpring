package io.yeahx4.myspring.repository

import io.yeahx4.myspring.domain.Member
import java.util.Optional
import javax.sql.DataSource
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.simple.SimpleJdbcInsert

class JdbcTemplateMemberRepository(dataSource: DataSource) : MemberRepository {
    private var jdbcTemplate: JdbcTemplate = JdbcTemplate(dataSource)

    private fun memberRowMapper(): RowMapper<Member> {
        return RowMapper<Member> { rs, _ ->
            val member = Member(rs.getLong("id"), rs.getString("name"))
            member
        }
    }

    override fun save(member: Member): Member {
        val jdbcInsert = SimpleJdbcInsert(jdbcTemplate)
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id")

        val parameters = mapOf<String, Any>("name" to member.memberName)

        val key = jdbcInsert.executeAndReturnKey(MapSqlParameterSource(parameters))
        member.setId(key.toLong())

        return member
    }

    override fun findByMemberId(id: Long): Optional<Member> {
        val result = jdbcTemplate.query("SELECT * FROM member WHERE id = ?", memberRowMapper(), id)
        return result.stream().findAny()
    }

    override fun findByMemberName(name: String): Optional<Member> {
        val result = jdbcTemplate.query("SELECT * FROM member WHERE name = ?", memberRowMapper(), name)
        return result.stream().findAny()
    }

    override fun findAll(): List<Member> {
        return jdbcTemplate.query("SELECT * FROM member", memberRowMapper())
    }
}
