package com.mirror.alogeda.commons.security;

import javax.ws.rs.HttpMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@CrossOrigin
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors();

		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/**").permitAll()
				// .antMatchers(HttpMethod.POST, "/api/login").permitAll()
				.anyRequest().authenticated();
				// .and()
				// .addFilterBefore(new JWTLoginFilter("/api/login", authenticationManager()),
				// 		UsernamePasswordAuthenticationFilter.class)
				// .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

		// OPTIONS NESSA BOSTA
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/**").permitAll()
				// .antMatchers(HttpMethod.OPTIONS, "/api/login").permitAll()
				.anyRequest().authenticated();
				// .and()
				// .addFilterBefore(new JWTLoginFilter("/api/login", authenticationManager()),
				// 		UsernamePasswordAuthenticationFilter.class)
				// .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
		// auth.inMemoryAuthentication().getUserDetailsService().createUser(User.withUsername("admin").password("password").roles("admin").build());
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(11);
	}

}
