package B4F2.PetStagram.member.service;


import B4F2.PetStagram.email.entity.EmailConfirmToken;
import B4F2.PetStagram.email.service.EmailConfirmTokenService;
import B4F2.PetStagram.search.service.SearchService;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
import B4F2.PetStagram.member.util.domainChanger;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final SearchService searchService;
    private final EmailConfirmTokenService emailConfirmTokenService;


    public Optional<Member> findValidMember(String email, String password){
        return memberRepository.findByEmail(email).stream().filter(
                        member -> member.getPassword().equals(password))
                .findFirst();
    }
    
    public Optional<Member> findByIdAndEmail(Long id, String email){
        return memberRepository.findById(id)
                .stream().filter(customer->customer.getEmail().equals(email))
                .findFirst();
    }

    /**
     * 회원 가입 로직
     */
    public boolean register(String email, String name, String password, String phone) {

        if (isEmailDuplicate(email)) {
            return false;
        }

        Member member = new Member();
        member.setEmail(email);
        member.setName(name);
        member.setPassword(passwordEncoder.encode(password));
        member.setPhone(phone);
        member.setRegDt(LocalDateTime.now());

        memberRepository.save(member);

        this.searchService.addAutocompleteKeyword(member.getEmail());

        return true;
    }

    /**
     * 중복 이메일 체크 로직
     */
    public boolean isEmailDuplicate(String email) {
        return memberRepository.existsByEmail(email);
    }

    /**
     * 이메일 인증 로직
     */
    public void confirmEmail(String token) {
        EmailConfirmToken emailConfirmToken = emailConfirmTokenService.findByIdAndExpirationDateAfterAndExpired(token);
        Optional<Member> optionalMember = memberRepository.findByEmail(emailConfirmToken.getEmail());
        emailConfirmTokenService.expireToken(emailConfirmToken); // 토큰 만료 로직을 구현해주면 된다. ex) expired 값을 true로 변경
        Member member = domainChanger.optionalMemberToMember(optionalMember);
        member.emailVerifiedSuccess();    // 유저의 이메일 인증 값 변경 로직을 구현해주면 된다. ex) emailVerified 값을 true로 변경
        memberRepository.save(member);
    }

}
