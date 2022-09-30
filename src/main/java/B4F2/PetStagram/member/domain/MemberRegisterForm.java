package B4F2.PetStagram.member.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class MemberRegisterForm {

    @NotEmpty(message = "아이디를 입력해주세요.")
    private String email;

    @NotEmpty(message = "이름을 입력해주세요.")
    private String name;

    @Size(min = 6, max = 10, message = "비밀번호는 6자 이상 10자 이하로 입력해주세요.")
    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password;

    @NotEmpty(message = "비밀번호를 한번 더 입력해주세요.")
    private String password2;

    @NotEmpty(message = "전화번호를 입력해주세요.")
    private String phone;
}