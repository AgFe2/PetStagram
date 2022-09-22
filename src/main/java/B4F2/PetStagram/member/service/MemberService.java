package B4F2.PetStagram.member.service;


import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Optional<Member> findValidMember(String email, String password) {
        return memberRepository.findByEmail(email).stream().filter(
                        member -> member.getPassword().equals(password))
                .findFirst();
    }

    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email)
                .stream().filter(customer -> customer.getEmail().equals(email))
                .findFirst();
    }
}
