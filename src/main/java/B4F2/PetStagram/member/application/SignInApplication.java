package B4F2.PetStagram.member.application;

import B4F2.PetStagram.member.util.Aes256Util;
import B4F2.PetStagram.member.util.JwtAuthenticationProvider;
import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.member.domain.SignInForm;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
import B4F2.PetStagram.member.service.MemberService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class SignInApplication {

    @Value("{spring.jwt.secret}")
    private String secretKey;

    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final JwtAuthenticationProvider provider;
    private final PasswordEncoder passwordEncoder;


    public String SignInToken(SignInForm form){

        /*====인크립트 사용 전 테스트용====*/

        Member m = memberService.findValidMember(form.getEmail(), form.getPassword())
                .orElseThrow(() -> new CustomException(ErrorCode.LOGIN_FAIL));

        return provider.createToken(m.getEmail());


        /* todo =====인크립트 사용시=====*/

//        Member m = this.memberRepository.findByEmail(form.getEmail())
//                .orElseThrow(() -> new CustomException(ErrorCode.INVALID_EMAIL));
//
//        if (!this.passwordEncoder.matches(form.getPassword(), m.getPassword())){
//            throw new CustomException(ErrorCode.INVALID_PASSWORD);
//        }
//
//        return provider.createToken(m.getEmail());


    }
}

