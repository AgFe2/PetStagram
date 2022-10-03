package B4F2.PetStagram.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    ///login
    LOGIN_FAIL(HttpStatus.BAD_REQUEST,"아이디나 패스워드를 확인해 주세요."),

    INVALID_EMAIL(HttpStatus.BAD_REQUEST,"잘못된 아이디(이메일)입니다"),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST,"잘못된 패스워드입니다"),

    USER_NOT_FOUND(HttpStatus.BAD_REQUEST,"해당 유저를 찾을 수 없습니다"),

    //Feed 돤련 오류
    NOT_FOUND_BOARD(HttpStatus.BAD_REQUEST, "해당 게시물을 찾을 수 없습니다."),
    WRONG_APPROACH(HttpStatus.BAD_REQUEST,"잘못된 접근 방법입니다."),

    UN_MATCH_ID(HttpStatus.BAD_REQUEST,"작성 된 게시물의 Id와 일치하지 않습니다."),

    REGISTER_FAIL(HttpStatus.BAD_REQUEST,"아이디나 패스워드를 확인해 주세요."),
    PASSWORD_INCORRECT(HttpStatus.BAD_REQUEST,"비밀번호가 일치하지 않습니다."),
    DUPLICATE_MEMBER(HttpStatus.BAD_REQUEST,"이미 가입된 회원입니다."),

    EMAIL_AUTH_FAIL(HttpStatus.BAD_REQUEST,"이메일 인증에 실패 했습니다."),

    //comment
    COMMENT_NOT_FOUND(HttpStatus.BAD_REQUEST,"해당 댓글을 찾을 수 없습니다."),
    COMMENT_DELETE_UNAUTHORIZED(HttpStatus.BAD_REQUEST,"삭제 권한이 없습니다.")
    ;

    private final HttpStatus httpStatus;
    private final String detail;
}
