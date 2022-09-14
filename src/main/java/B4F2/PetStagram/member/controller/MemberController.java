package B4F2.PetStagram.member.controller;

import B4F2.PetStagram.member.MemberRegisterForm;
import B4F2.PetStagram.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/register")
    public String register(MemberRegisterForm memberRegisterForm) {
        return "register_form";
    }

    @PostMapping("/member/register")
    public String signup(@Valid MemberRegisterForm memberRegisterForm,
                         BindingResult bindingResult) {
        System.out.println(memberRegisterForm.getMemberId());
        System.out.println(memberRegisterForm.getName());
        System.out.println(memberRegisterForm.getPassword1());
        System.out.println(memberRegisterForm.getPassword2());
        System.out.println(memberRegisterForm.getPhone());

        if (bindingResult.hasErrors()) {
            System.out.println("에러 체크");
            return "register_form";
        }

        if (!memberRegisterForm.getPassword1().equals(memberRegisterForm.getPassword2())) {
            bindingResult.rejectValue("password2",
                    "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            System.out.println("비밀번호가 다릅니다.");
            return "register_form";
        }

        memberService.register(
                memberRegisterForm.getMemberId(),
                memberRegisterForm.getName(),
                memberRegisterForm.getPassword1(),
                memberRegisterForm.getPhone());

        return "redirect:/";
    }
}