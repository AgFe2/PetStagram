package B4F2.PetStagram.member.repository;

import B4F2.PetStagram.member.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {

    List<Member> searchByEmail(String email);
}
