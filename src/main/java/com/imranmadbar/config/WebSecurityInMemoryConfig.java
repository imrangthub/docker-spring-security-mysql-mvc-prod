package com.imranmadbar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.imranmadbar.config.CustomAccessDeniedHandler;
import com.imranmadbar.config.CustomAuthenticationFailureHandler;
import com.imranmadbar.config.CustomAuthenticationProvider;
import com.imranmadbar.config.CustomAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityInMemoryConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomAccessDeniedHandler customAccessDeniedHandler;
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;
	
	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	
	
//	@Override
//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//	        .withUser("imranmadbar").password(passwordEncoder().encode("imranmadbar")).roles("SUPERADMIN", "ADMIN", "MANAGER");
//	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider);
		auth.eraseCredentials(false);
	}
	
	
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/book/**").permitAll()
        .antMatchers("/admin/**").hasAnyRole("ADMIN")
        .antMatchers("/manager/").hasAnyRole("MANAGER")
        .antMatchers("/super-admin/**").hasAnyRole("SUPERADMIN")
        .antMatchers("/role/**").hasAnyRole("SUPERADMIN")
        .antMatchers("/user/**").hasAnyRole("SUPERADMIN")
        .antMatchers("/user-role/**").hasAnyRole("SUPERADMIN")
        .antMatchers("/anonymous*").anonymous()
        .antMatchers("/login/").permitAll()
        .antMatchers("/console/**").permitAll()
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
        .headers().frameOptions().disable()
        .and()
        .exceptionHandling().accessDeniedPage("/access-denied")
        .and()
            .csrf()
            .disable();
    }
	
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	 return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
	

}
