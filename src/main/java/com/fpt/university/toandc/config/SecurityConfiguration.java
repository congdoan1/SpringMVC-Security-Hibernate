//package com.fpt.university.toandc.config;
//
//import com.fpt.university.toandc.security.AppUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * Created by ToanQri on 9/20/2016.
// */
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private AppUserDetailsService appUserDetailsService;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(appUserDetailsService);
//       // auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .antMatchers("/admin/**").access("hasRole('ADMIN')")
//                .and().formLogin().loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .and().csrf()
//                .and().exceptionHandling().accessDeniedPage("/access_denied");
//    }
//}
