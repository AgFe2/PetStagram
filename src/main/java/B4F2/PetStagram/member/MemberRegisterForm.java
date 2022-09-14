package B4F2.PetStagram.member;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class MemberRegisterForm {

    @NotEmpty(message = "아이디는 필수항목입니다.")
    private String memberId;

    @NotEmpty(message = "이름은 필수항목입니다.")
    private String name;

    @Size(min = 6, max = 10)
    @NotEmpty(message = "비밀번호는 6~10글자 사이로 제한됩니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;

    @NotEmpty(message = "전화번호는 필수항목입니다.")
    private String phone;
}