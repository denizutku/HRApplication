package deniz.spring.hrapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            auth.inMemoryAuthentication()
                    .withUser("hrmanager")
                    .password(encoder.encode("password"))
                    .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/createjob").hasRole("ADMIN")
                .antMatchers("/applications").hasRole("ADMIN")
                .and().formLogin();
    }
}
