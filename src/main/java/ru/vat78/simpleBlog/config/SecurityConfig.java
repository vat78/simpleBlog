package ru.vat78.simpleBlog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.vat78.simpleBlog.services.SecurityServiceUsesDB;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .and()

                //.rememberMe()
                //.key("SimpleBlog")
                //.tokenValiditySeconds(2419200)
                //.and()

                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/", false)
                .permitAll()
                .and()

                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .and()

                .csrf().disable();
    }

    @Autowired
    private SecurityServiceUsesDB securityServiceUsesDB;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityServiceUsesDB);
    }
}
