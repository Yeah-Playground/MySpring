package io.yeahx4.myspring.controller

import io.yeahx4.myspring.domain.Member
import io.yeahx4.myspring.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

data class MemberForm(var name: String)

@Controller
class MemberController(private val memberService: MemberService) {
    @GetMapping("/members/new")
    fun createForm() = "members/createMemberForm"

    @PostMapping("/members/new")
    fun create(form: MemberForm): String {
        val member = Member(form.name)
        memberService.join(member)

        return "redirect:/"
    }

    @GetMapping("/members")
    fun list(model: Model): String {
        val members = memberService.findMembers()
        model.addAttribute("members", members)

        return "members/memberList"
    }
}
