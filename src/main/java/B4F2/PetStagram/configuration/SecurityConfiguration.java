package B4F2.PetStagram.configuration;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {

//    private final MemberFilter memberFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .cors().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                .authorizeRequests()
                .antMatchers(
                        // todo 모든 접근 허용 경로
                        "/*"
//                        ,
//                        "/**"
//                        ,
//                        "/member/*"
                ).permitAll()

//                .anyRequest().authenticated()

                .and()

                .build();
    }
//
//        return http
//
//                //todo custom필터 적용...
////                .addFilterAfter(this.memberFilter, UsernamePasswordAuthenticationFilter.class)
//
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//
//                .authorizeRequests()
//                //todo 전체 접근 허용 경로
//                .antMatchers(
//                        "/*"
////                        ,
////                        "/*"
////                                ,
////                                "/member/**"
//                )
//                .permitAll()
//                .and()
//
//                //todo custom필터 적용...
////                .addFilterBefore(this.memberFilter, UsernamePasswordAuthenticationFilter.class)
//
//                // todo 요놈도 문제 -> MemberFilter를 customFilter 적용 후 authenticated사용해야될듯
////                .authenticated() //적용시 403에러 정상적으로 뜨지만, 로그인도 토큰들고와도 403띄움
//
////             .permitAll() //적용시 403에러 안뜨지만, 로그인 정상작동
//
//
////                .and()
//
////                todo 프론트 협업시 로그인 실패 이 방식 사용
////                .formLogin()
////                .loginPage("/login")
////                .failureHandler(getFailureHandler())
////                .permitAll()
////                .and()
//
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
//                .logoutSuccessUrl("/")
//                .invalidateHttpSession(true)
//                .and()
//
////                .antMatchers(HttpMethod.GET, "/**")
////                .permitAll()
////                .anyRequest().authenticated()
////                .and()
//
//                .build();
//    }




}
