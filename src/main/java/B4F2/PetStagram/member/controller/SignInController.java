package B4F2.PetStagram.member.controller;

import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.member.application.SignInApplication;
import B4F2.PetStagram.member.domain.SignInForm;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class SignInController {

    private final SignInApplication signInApplication;

    @ApiOperation(value = "로그인", notes = "로그인 성공시 body에 로그인 유저의 email을 지닌 jwt token반환")
    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody SignInForm form){

        return ResponseEntity.ok(signInApplication.SignInToken(form));
    }

}
