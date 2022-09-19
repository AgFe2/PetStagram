package B4F2.PetStagram.member.util;

import B4F2.PetStagram.member.entity.Member;

import java.util.Optional;

public class domainChanger {
    public static Member optionalMemberToMember(Optional<Member> optionalMember) {
        Member member = new Member();

        member.setName(optionalMember.get().getName());
        member.setPassword(optionalMember.get().getPassword());
        member.setEmail(optionalMember.get().getEmail());
        member.setPhone(optionalMember.get().getPhone());
        member.setRegDt(optionalMember.get().getRegDt());
        member.setEmailAuthYn(optionalMember.get().isEmailAuthYn());

        return member;
    }
}
