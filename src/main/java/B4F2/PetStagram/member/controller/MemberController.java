package B4F2.PetStagram.member.controller;

import B4F2.PetStagram.email.service.EmailConfirmTokenService;
import B4F2.PetStagram.member.MemberRegisterForm;
import B4F2.PetStagram.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;
    private final EmailConfirmTokenService emailConfirmTokenService;

    @GetMapping("/member/register")
    public String register(MemberRegisterForm memberRegisterForm) {
        return "register_form";
    }

    @PostMapping("/member/register")
    public String register(@Valid MemberRegisterForm memberRegisterForm,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register_form";
        }

        if (!memberRegisterForm.getPassword1().equals(memberRegisterForm.getPassword2())) {
            bindingResult.rejectValue("password2",
                    "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "register_form";
        }

        memberService.register(
                memberRegisterForm.getMemberId(),
                memberRegisterForm.getName(),
                memberRegisterForm.getPassword1(),
                memberRegisterForm.getPhone());

        emailConfirmTokenService.createEmailConfirmationToken(memberRegisterForm.getMemberId(), memberRegisterForm.getMemberId());

        return "redirect:/";
    }

    @GetMapping("confirm-email")
    public String viewConfirmEmail(@Valid @RequestParam String token){
        memberService.confirmEmail(token);

        return "redirect:/login";
    }
}