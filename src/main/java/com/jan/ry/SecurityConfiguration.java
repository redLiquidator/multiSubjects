package com.jan.ry;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity //this is the web level security
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
				.withUser("user")
				.password("user")
				.roles("USER")
				.and()
				.withUser("admin")
				.password("admin")
				.roles("ADMIN");
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		//password should be encoded
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		  .antMatchers("/admin").hasRole("ADMIN") //USER role can access
		       .antMatchers("/user").hasRole("USER") //ADMIN role can access
		       .antMatchers("/").permitAll() //any role can access anywhere
		       .and().formLogin();
	}

}
