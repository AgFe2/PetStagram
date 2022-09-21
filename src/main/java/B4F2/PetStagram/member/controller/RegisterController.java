package B4F2.PetStagram.member.controller;

import B4F2.PetStagram.email.service.EmailConfirmTokenService;
import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.domain.MemberRegisterForm;
import B4F2.PetStagram.member.service.MemberService;
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

    private final MemberService memberService;
    private final EmailConfirmTokenService emailConfirmTokenService;

    @PostMapping("/member/register")
    public ResponseEntity<Member> register(@RequestBody MemberRegisterForm memberRegisterForm) {

        if (memberRegisterForm.getEmail() == null ||
                memberRegisterForm.getName() == null ||
                memberRegisterForm.getPassword1() == null ||
                memberRegisterForm.getPassword2() == null ||
                memberRegisterForm.getPhone() == null) {
            throw new CustomException(ErrorCode.REGISTER_FAIL);
        }

        if (!memberRegisterForm.getPassword1().equals(memberRegisterForm.getPassword2())) {
            throw new CustomException(ErrorCode.PASSWORD_INCORRECT);
        }

        Member member = Member.builder()
                .email(memberRegisterForm.getEmail())
                .name(memberRegisterForm.getName())
                .password(memberRegisterForm.getPassword1())
                .phone(memberRegisterForm.getPhone())
                .build();

        if (memberService.isMember(member.getEmail())) {
            throw new CustomException(ErrorCode.DUPLICATE_MEMBER);
        }

        memberService.register(member);

        emailConfirmTokenService.createEmailConfirmationToken(member.getEmail());

        return ResponseEntity.ok(member);
    }

    @GetMapping("confirm-email")
    public String viewConfirmEmail(@Valid @RequestParam String token) {
        memberService.confirmEmail(token);

        return "redirect:/login";
    }
}