package B4F2.PetStagram.member.controller;

import B4F2.PetStagram.email.service.EmailConfirmTokenService;
import B4F2.PetStagram.member.domain.MemberRegisterForm;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class RegisterController {

    private final RegisterService registerService;
    private final EmailConfirmTokenService emailConfirmTokenService;

    @PostMapping("/member/register")
    public ResponseEntity<Member> register(@RequestBody MemberRegisterForm memberRegisterForm) {

        // 회원가입양식 유효성 검사
        registerService.checkValidation(memberRegisterForm);

        // 회원가입진행
        Member member = registerService.register(memberRegisterForm);

        // 인증메일 발송
        emailConfirmTokenService.createEmailConfirmationToken(member.getEmail());

        return ResponseEntity.ok(member);
    }

    @GetMapping("/confirm-email")
    public String viewConfirmEmail(@Valid @RequestParam String token) {
        registerService.confirmEmail(token);

        return "redirect:/member/sign-in";
    }
}