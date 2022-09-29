package B4F2.PetStagram.member.service;

import B4F2.PetStagram.email.entity.EmailConfirmToken;
import B4F2.PetStagram.email.service.EmailConfirmTokenService;
import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.follow.service.FollowService;
import B4F2.PetStagram.member.domain.MemberRegisterForm;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailConfirmTokenService emailConfirmTokenService;
    private final FollowService followService;


    /**
     * 회원가입양식 유효성 검사
     */
    public void checkValidation(MemberRegisterForm memberRegisterForm) {
        // 필수항목
        if (memberRegisterForm.getEmail() == null ||
                memberRegisterForm.getName() == null ||
                memberRegisterForm.getPassword() == null ||
                memberRegisterForm.getPassword2() == null ||
                memberRegisterForm.getPhone() == null) {
            throw new CustomException(ErrorCode.REGISTER_FAIL);
        }

        // 비밀번호, 비밀번호확인 일치하는지 체크
        if (!memberRegisterForm.getPassword().equals(memberRegisterForm.getPassword2())) {
            throw new CustomException(ErrorCode.PASSWORD_INCORRECT);
        }

        // 이미 가입된 회원인지 확인
        if (memberRepository.existsByEmail(memberRegisterForm.getEmail())) {
            throw new CustomException(ErrorCode.DUPLICATE_MEMBER);
        }
    }

    /**
     * 회원 가입 로직
     */
    public Member register(MemberRegisterForm memberRegisterForm) {

        Member member = Member.builder()
                .email(memberRegisterForm.getEmail())
                .name(memberRegisterForm.getName())
                .password(passwordEncoder.encode(memberRegisterForm.getPassword()))
                .phone(memberRegisterForm.getPhone())
                .emailAuthYn(false)
                .build();

        memberRepository.save(member);

        // following follower count 테이블 생성
        followService.createFollowCount(member);

        return member;
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

}
