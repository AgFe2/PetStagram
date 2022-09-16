package B4F2.PetStagram.member.service;

import B4F2.PetStagram.email.entity.EmailConfirmToken;
import B4F2.PetStagram.email.service.EmailConfirmTokenService;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailConfirmTokenService emailConfirmTokenService;

    /**
     * 회원 가입 로직
     */
    public void register(String memberId, String name, String password, String phone) {
        Member member = new Member();
        member.setMemberId(memberId);
        member.setName(name);
        member.setPassword(passwordEncoder.encode(password));
        member.setPhone(phone);
        member.setRegDt(LocalDate.now());

        memberRepository.save(member);
    }

    /**
     * 이메일 인증 로직
     */
    public void confirmEmail(String token) {
        EmailConfirmToken emailConfirmToken = emailConfirmTokenService.findByIdAndExpirationDateAfterAndExpired(token);
        Member member = memberRepository.findMemberByMemberId(emailConfirmToken.getMemberId());
        emailConfirmTokenService.expireToken(emailConfirmToken); // 토큰 만료 로직을 구현해주면 된다. ex) expired 값을 true로 변경
        member.emailVerifiedSuccess();    // 유저의 이메일 인증 값 변경 로직을 구현해주면 된다. ex) emailVerified 값을 true로 변경
        memberRepository.save(member);
    }
}