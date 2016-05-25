package ru.vat78.simpleBlog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.vat78.simpleBlog.services.SecurityServiceUsesDB;


@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
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
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .permitAll()
                .defaultSuccessUrl("/", false)
                .and()
                .logout()
                .permitAll();

    }

    @Autowired
    private SecurityServiceUsesDB securityServiceUsesDB;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityServiceUsesDB);
        //auth.inMemoryAuthentication()
        //        .withUser("user").password("user").roles("USER").and()
        //        .withUser("admin").password("admin").roles("USER", "ADMIN");
    }
}
