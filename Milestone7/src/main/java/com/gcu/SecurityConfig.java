package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gcu.BusinessLayer.UserBusinessService;

//

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserBusinessService service;
	
	@Bean
	BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{ 
		http
			.authorizeRequests()
				.antMatchers("/administrationmode").hasAuthority("ADMIN")
				.antMatchers("/administrationmode/**").hasAuthority("ADMIN")
				.antMatchers("/addproduct").hasAuthority("ADMIN")
//				
//				.antMatchers(HttpMethod.POST, "/api/**").hasAnyRole("ADMIN")
//				.antMatchers(HttpMethod.PUT, "/api/**").hasAnyRole("ADMIN")
//				.antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole("ADMIN")
//				
				.antMatchers("/api/**").authenticated()
				.antMatchers("/orders/**").authenticated()
				.antMatchers("/login/", "/img/**").permitAll()
			.and()
			
			.httpBasic()
				
			.and()
			
			.formLogin()
				.loginPage("/login/")
				
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
				
				.defaultSuccessUrl("/products/")
			.and()
			
			.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.permitAll()
				.logoutSuccessUrl("/login/")
			.and()
		.csrf().ignoringAntMatchers("/api/**");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		 //String password = new BCryptPasswordEncoder().encode("pieces");
		 //System.out.println(">> Encrypted password " + password);
		
		auth.userDetailsService(service).passwordEncoder(passwordEncoder);
	} 
}
