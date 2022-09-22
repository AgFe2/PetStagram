package B4F2.PetStagram.member.service;


import B4F2.PetStagram.email.entity.EmailConfirmToken;
import B4F2.PetStagram.email.service.EmailConfirmTokenService;
import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
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
    private final EmailConfirmTokenService emailConfirmTokenService;


    public Optional<Member> findValidMember(String email, String password) {
        return memberRepository.findByEmail(email).stream().filter(
                        member -> member.getPassword().equals(password))
                .findFirst();
    }

    public Optional<Member> findByIdAndEmail(Long id, String email) {
        return memberRepository.findById(id)
                .stream().filter(customer -> customer.getEmail().equals(email))
                .findFirst();
    }

    /**
     * 회원인지 확인
     */
    public boolean isMember(String email) {
        return memberRepository.existsByEmail(email);
    }

    /**
     * 회원 가입 로직
     */
    public void register(Member member) {

        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setRegDt(LocalDateTime.now());
        member.setEmailAuthYn(false);
        member.setFollowerCount(0);
        member.setFollowingCount(0);

        memberRepository.save(member);
    }

    /**
     * 이메일 인증 로직
     */
    public void confirmEmail(String token) {
        // 유효토큰 검색
        EmailConfirmToken emailConfirmToken = emailConfirmTokenService.findByIdAndExpirationDateAfterAndExpired(token);

        // 인증할 유저 선택
        Optional<Member> optionalMember = memberRepository.findByEmail(emailConfirmToken.getEmail());
        if (!optionalMember.isPresent()) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        Member member = optionalMember.get();
        member.emailVerifiedSuccess();
        memberRepository.save(member);
        emailConfirmTokenService.expireToken(emailConfirmToken);
    }

    /**
     * 팔로우 인원 증가
     */
    public void increaseFollowerCount(String followEmail) {
        Optional<Member> optionalMember = memberRepository.findByEmail(followEmail);

        if (!optionalMember.isPresent()) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        Member member = optionalMember.get();
        member.setFollowerCount(member.getFollowerCount() + 1);
        memberRepository.save(member);
    }

    /**
     * 팔로잉 인원 증가
     */
    public void increaseFollowingCount(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);

        if (!optionalMember.isPresent()) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        Member member = optionalMember.get();
        member.setFollowingCount(member.getFollowingCount() + 1);
        memberRepository.save(member);
    }

    /**
     * 팔로워 인원 감소
     */
    public void decreaseFollowerCount(String followEmail) {
        Optional<Member> optionalMember = memberRepository.findByEmail(followEmail);

        if (!optionalMember.isPresent()) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        Member member = optionalMember.get();
        member.setFollowerCount(member.getFollowerCount() - 1);
        memberRepository.save(member);
    }

    /**
     * 팔로잉 인원 감소
     */
    public void decreaseFollowingCount(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);

        if (!optionalMember.isPresent()) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        Member member = optionalMember.get();
        member.setFollowingCount(member.getFollowingCount() - 1);
        memberRepository.save(member);
    }
}
