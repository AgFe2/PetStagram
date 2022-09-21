package B4F2.PetStagram.member.controller;

import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.member.application.SignInApplication;
import B4F2.PetStagram.member.domain.MemberDto;
import B4F2.PetStagram.member.domain.MemberVo;
import B4F2.PetStagram.member.domain.SignInForm;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.service.MemberService;
import B4F2.PetStagram.member.util.JwtAuthenticationProvider;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class SignInController {

    private final JwtAuthenticationProvider provider;
    private final MemberService memberService;

    private final SignInApplication signInApplication;

    @ApiOperation(value = "로그인", notes = "로그인 성공시 body에 로그인 유저의 email을 지닌 jwt token반환")
    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody SignInForm form){

        return ResponseEntity.ok(signInApplication.SignInToken(form));
    }

    @ApiOperation(value = "jwt토큰으로 이메일 불러오기 테스트")
    @PostMapping("/sign-in-tokenTest")
    public ResponseEntity<MemberDto> signInTokenTest(@RequestHeader(name = "X-AUTH-TOKEN") String token){

        MemberVo vo = provider.getMemberVo(token);
        Member m = memberService.findByIdAndEmail(vo.getId(), vo.getEmail()).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );

        return ResponseEntity.ok(MemberDto.of(m));
    }

//    public String getEmail(String token){
//        MemberVo vo = provider.getMemberVo(token);
//        Member m = memberService.findByIdAndEmail(vo.getId(), vo.getEmail()).orElseThrow(
//                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
//        );
//
//        String email = String.valueOf(MemberDto.of(m));
//        return email;
//    }

}
