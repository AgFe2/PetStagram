package B4F2.PetStagram.member.application;

import B4F2.PetStagram.configuration.JwtAuthenticationProvider;
import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.member.domain.SignInForm;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
import B4F2.PetStagram.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SignInApplication {

    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final JwtAuthenticationProvider provider;
    private final PasswordEncoder passwordEncoder;


    public String SignInToken(SignInForm form){

        /*====인크립트 사용 전 테스트용====*/

        Member m = memberService.findValidMember(form.getEmail(), form.getPassword())
                .orElseThrow(() -> new CustomException(ErrorCode.LOGIN_FAIL));

        return provider.createToken(m.getEmail());


        /*=====인크립트 사용시=====*/
//
//        Member m = this.memberRepository.findByEmail(form.getEmail())
//                .orElseThrow(() -> new CustomException(ErrorCode.INVALID_EMAIL));
//
//        if (!this.passwordEncoder.matches(form.getPassword(), m.getPassword())){
//            throw new CustomException(ErrorCode.INVALID_PASSWORD);
//        }
//
//        return provider.createToken(m.getEmail(),m.getId());


    }
}

