package B4F2.PetStagram.configuration;


import B4F2.PetStagram.configuration.filter.MemberFilter;
import B4F2.PetStagram.member.service.MemberService;
import B4F2.PetStagram.member.util.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {

    private final JwtAuthenticationProvider provider;
    private final MemberService memberService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .cors().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .and()

                .authorizeRequests()
                .antMatchers(
                        // todo 모든 접근 허용 경로
//                        "/" ,
                        "/**"
//                        ,"/member/*"
                ).permitAll()
                .and()

                //todo 접근제한경로
                .requestMatchers()
                .antMatchers(
                        "/example"
//                        , "/member/sign-in"
                        )
                .and()
                .addFilterAfter(new MemberFilter(provider, memberService), UsernamePasswordAuthenticationFilter.class)


                .build();
    }
}
