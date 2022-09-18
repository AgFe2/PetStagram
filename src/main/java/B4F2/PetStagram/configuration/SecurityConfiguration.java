package B4F2.PetStagram.configuration;


import B4F2.PetStagram.configuration.filter.MemberFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;


@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {

    private final MemberFilter memberFilter;

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
//                        "/" ,
                        "/**"
//                        ,"/member/*"
                ).permitAll()
                .and()

                //todo 접근제한경로
                .requestMatchers()
                .antMatchers(
                        "/member/sign-in"
                        , "/example"
                        )
                .and()
                .addFilterAfter(this.memberFilter, UsernamePasswordAuthenticationFilter.class)

                .build();
    }

}
