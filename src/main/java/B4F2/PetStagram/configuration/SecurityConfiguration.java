package B4F2.PetStagram.configuration;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {

    @Bean
    MemberAuthenticationFailureHandler getFailureHandler(){
        return new MemberAuthenticationFailureHandler();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        return http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                .authorizeRequests()
                //todo 전체 접근 허용 경로
                .antMatchers("/**"
                        , "/member/**")
                .permitAll()
                .and()

//                todo 프론트 협업시 로그인 실패 이 방식 사용
//                .formLogin()
//                .loginPage("/login")
//                .failureHandler(getFailureHandler())
//                .permitAll()
//                .and()

                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .and()

//                .antMatchers(HttpMethod.GET, "/**")
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()

                .build();
    }
}