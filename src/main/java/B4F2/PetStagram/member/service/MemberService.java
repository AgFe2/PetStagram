package B4F2.PetStagram.member.service;

import B4F2.PetStagram.member.Member;
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

    public void register(String memberId, String name, String password, String phone) {

        Member member = new Member();
        member.setMemberId(memberId);
        member.setName(name);
        member.setPassword(passwordEncoder.encode(password));
        member.setPhone(phone);
        member.setRegDt(LocalDate.now());

        memberRepository.save(member);
    }

}