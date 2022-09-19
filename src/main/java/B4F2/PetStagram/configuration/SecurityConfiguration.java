/*
package B4F2.PetStagram.configuration;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

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

        return http.authorizeRequests()
                .antMatchers("/"
                                    , "/**")
                .permitAll().and()

                .formLogin()
                .loginPage("/login")
                .failureHandler(getFailureHandler())
                .permitAll().and()

                .logout()
                .logoutSuccessUrl("/")
                .permitAll().and()

//                .antMatchers(HttpMethod.GET, "/**")
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()

                .build();
    }

}
 */
