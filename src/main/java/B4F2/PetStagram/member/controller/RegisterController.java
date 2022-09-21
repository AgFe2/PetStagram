package B4F2.PetStagram.member.controller;

import B4F2.PetStagram.email.service.EmailConfirmTokenService;
import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.entity.MemberRegisterForm;
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
//            ,BindingResult bindingResult) {

//        if (bindingResult.hasErrors()) {
//            throw new CustomException(ErrorCode.REGISTER_FAIL);
//        }
//
//        if (!memberRegisterForm.getPassword1().equals(memberRegisterForm.getPassword2())) {
//            bindingResult.rejectValue("password2",
//                    "passwordInCorrect",
//                    "2개의 패스워드가 일치하지 않습니다.");
//            throw new CustomException(ErrorCode.PASSWORD_INCORRECT);
//        }

        Member member = Member.builder()
                .email(memberRegisterForm.getEmail())
                .name(memberRegisterForm.getName())
                .password(memberRegisterForm.getPassword1())
                .phone(memberRegisterForm.getPhone())
                .build();

        if (memberService.isEmailDuplicate(member.getEmail())) {
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