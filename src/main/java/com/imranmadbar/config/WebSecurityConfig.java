package com.imranmadbar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	        .withUser("manager").password(passwordEncoder().encode("123456")).roles("MANAGER")
	        .and()
	        .withUser("admin").password(passwordEncoder().encode("1234567")).roles("ADMIN")
	        .and()
	        .withUser("imran").password(passwordEncoder().encode("12345678")).roles("SUPERADMIN");
	}
	
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/manager/").permitAll()
        .antMatchers("/admin/**").hasAnyRole("ADMIN", "SUPERADMIN")
        .antMatchers("/super-admin/**").hasAnyRole("SUPERADMIN")
        .antMatchers("/anonymous*").anonymous()
        .antMatchers("/login/").permitAll()
        .anyRequest().authenticated()
        .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/home")
            .failureUrl("/login?error=true")
            .permitAll()
        .and()
            .logout()
            .logoutSuccessUrl("/home")
            .invalidateHttpSession(true)
            .permitAll()
        .and()
        .exceptionHandling().accessDeniedPage("/access-denied")
        .and()
            .csrf()
            .disable();
    }
	
	
	

}
