package B4F2.PetStagram.member.domain;

import B4F2.PetStagram.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberDto {

    private String email;

    public static MemberDto of(Member member){
        return new MemberDto(member.getEmail());
    }

}
