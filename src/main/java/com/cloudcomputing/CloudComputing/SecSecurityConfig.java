// package com.cloudcomputing.CloudComputing;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// @EnableWebSecurity
// public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

//     @Override
//     protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//         auth.inMemoryAuthentication()
//         .withUser("Admin").password(passwordEncoder().encode("Admin")).roles("ADMIN");
//     }

//     @Override
//     protected void configure(final HttpSecurity http) throws Exception {
//         http
//         .csrf().disable()
//         .authorizeRequests()
//         .antMatchers("/login*").permitAll()
//         .anyRequest().authenticated();
//     }
//     @Bean 
//     public PasswordEncoder passwordEncoder() { 
//         return new BCryptPasswordEncoder(); 
//     }

// }