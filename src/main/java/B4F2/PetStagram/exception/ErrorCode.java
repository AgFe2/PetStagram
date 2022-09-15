package B4F2.PetStagram.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    ///login
    LOGIN_FAIL(HttpStatus.BAD_REQUEST,"아이디나 패스워드를 확인해 주세요."),

    INVALID_EMAIL(HttpStatus.OK,"잘못된 아이디(이메일)입니다"),
    INVALID_PASSWORD(HttpStatus.OK,"잘못된 패스워드입니다")

    ;

    private final HttpStatus httpStatus;
    private final String detail;
}