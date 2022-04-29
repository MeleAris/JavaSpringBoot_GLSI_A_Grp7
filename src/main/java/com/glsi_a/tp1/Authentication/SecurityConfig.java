package com.glsi_a.tp1.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
               /* .inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin1234"))
                .roles("admin")
                .and()
                .withUser("jackk")
                .password(passwordEncoder().encode("12345"))
                .roles("user")
                .and()
                .withUser("aris")
                .password(passwordEncoder().encode("mel"))
                .roles("manager");*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/produit/show").hasRole("ADMIN")
                .antMatchers("/home").hasRole("USER")
                .and().formLogin().loginPage("/login")
                .and().logout().logoutUrl("/login");

    }
    @Bean
    PasswordEncoder getPasswordEncoder(){

        return NoOpPasswordEncoder.getInstance();
    }
}
