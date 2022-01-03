package com.example.hackathonendava.registration;

import javax.sql.DataSource;

//import com.example.hackathonendava.registration.users.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserInfoService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests()
                .antMatchers("/deadlines").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/management").hasAnyAuthority("ADMIN")
                .antMatchers("/static/**", "/media/**", "/scripts/**", "/style/**").permitAll()
                //.antMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
                //.antMatchers("/delete/**").hasAuthority("ADMIN")
                .antMatchers("/register").permitAll()
                .antMatchers("/process_register").permitAll()
                .antMatchers("/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .loginPage("/login_page")
                .loginProcessingUrl("/login")
                .usernameParameter("email")
                .and()
                .logout().permitAll()
                //.logoutUrl("/logout")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
        ;
    }

}
