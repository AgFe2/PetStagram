package B4F2.PetStagram.configuration;

import B4F2.PetStagram.member.util.JwtAuthenticationProvider;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@AllArgsConstructor
public class BearerAuthInterceptor implements HandlerInterceptor {
    private AuthorizationExtractor authExtractor;
    private JwtAuthenticationProvider jwtAuthenticationProvider;


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) {
        System.out.println(">>> interceptor.preHandle 호출");
        String token = authExtractor.extract(request, "Bearer");
        System.out.println("token:" + token);
        if (token == null || token.length() == 0) {
            return true;
        }

        if (!jwtAuthenticationProvider.validateToken(token)) {
            throw new IllegalArgumentException("유효하지 않은 토큰");
        }

        String email = jwtAuthenticationProvider.getSubject(token);
        request.setAttribute("email", email);
        return true;
    }
}
