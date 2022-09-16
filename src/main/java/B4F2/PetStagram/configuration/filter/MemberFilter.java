package B4F2.PetStagram.configuration.filter;

import B4F2.PetStagram.configuration.JwtAuthenticationProvider;
import B4F2.PetStagram.member.domain.MemberVo;
import B4F2.PetStagram.member.service.MemberService;
import lombok.RequiredArgsConstructor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

// todo 로그인유저만 접근 가능 경로 설정
@WebFilter(urlPatterns = "/member/sign-in")
@RequiredArgsConstructor
public class MemberFilter implements Filter {
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final MemberService memberService;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("X-AUTH-TOKEN");
        if(!jwtAuthenticationProvider.validateToken(token)){
            throw new ServletException("Invalid Access");
        }
        MemberVo vo = jwtAuthenticationProvider.getMemberVo(token);
        memberService.findByIdAndEmail(vo.getId(), vo.getEmail()).orElseThrow(
                ()->new ServletException("Invalid access")
        );
        chain.doFilter(request,response);
    }
}
