package B4F2.PetStagram.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    LOGIN_CHECK_FAIL(HttpStatus.BAD_REQUEST,"잘못된 아이디 혹은 패스워드입니다")

    ;

    private final HttpStatus httpStatus;
    private final String detail;
}
