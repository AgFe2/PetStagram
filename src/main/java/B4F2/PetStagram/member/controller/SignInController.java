package B4F2.PetStagram.member.controller;

import B4F2.PetStagram.exception.CustomException;
import B4F2.PetStagram.exception.ErrorCode;
import B4F2.PetStagram.member.application.SignInApplication;
import B4F2.PetStagram.member.domain.MemberDto;
import B4F2.PetStagram.member.domain.MemberVo;
import B4F2.PetStagram.member.domain.SignInForm;
import B4F2.PetStagram.member.domain.TokenResponse;
import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
import B4F2.PetStagram.member.service.MemberService;
import B4F2.PetStagram.member.util.JwtAuthenticationProvider;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class SignInController {

    private final MemberRepository memberRepository;
    private final JwtAuthenticationProvider provider;
    private final MemberService memberService;

    private final SignInApplication signInApplication;

    @ApiOperation(value = "로그인", notes = "로그인 성공시 body에 로그인 유저의 email을 지닌 access token반환")
    @PostMapping("/sign-in")
    public ResponseEntity<TokenResponse> signIn(@RequestBody SignInForm form){

        String token = signInApplication.SignInToken(form);

        return ResponseEntity.ok().body(new TokenResponse(token, "bearer"));
    }

    @GetMapping("/api/profile")
    public Object getUserFromToken(HttpServletRequest request) {
        String email = (String) request.getAttribute("email");
        Optional<Member> member = /*todo memberRepository맞나 확인*/memberRepository.findByEmail(email);

        return member;
    }


    //=====리팩토링 전 구현=====
    @ApiOperation(value = "jwt토큰으로 이메일 불러오기 테스트")
    @PostMapping("/sign-in-tokenTest")
    public ResponseEntity<MemberDto> signInTokenTest(@RequestHeader(name = "X-AUTH-TOKEN") String token){

        MemberVo vo = provider.getMemberVo(token);
        Member m = memberService.findByEmail(vo.getEmail()).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );

        return ResponseEntity.ok(MemberDto.of(m));
    }

}
