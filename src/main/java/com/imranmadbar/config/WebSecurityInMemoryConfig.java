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
public class WebSecurityInMemoryConfig extends WebSecurityConfigurerAdapter {

	
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	        .withUser("manager").password(passwordEncoder().encode("manager")).roles("MANAGER")
	        .and()
	        .withUser("admin").password(passwordEncoder().encode("admin")).roles("MANAGER","ADMIN")
	        .and()
	        .withUser("imranmadbar").password(passwordEncoder().encode("imranmadbar")).roles("SUPERADMIN", "ADMIN", "MANAGER");
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/admin/**").hasAnyRole("ADMIN")
        .antMatchers("/manager/").hasAnyRole("MANAGER")
        .antMatchers("/super-admin/**").hasAnyRole("SUPERADMIN")
        .antMatchers("/anonymous*").anonymous()
        .antMatchers("/login/").permitAll()
        .antMatchers("/resources/**", "/static/**","/webjars/**").permitAll()
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
	
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
	
	

}
