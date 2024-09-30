package com.LucasMotta.ProjetoBlog.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.LucasMotta.ProjetoBlog.services.DetailService;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class Security {
	
	@Autowired
	private DetailService detailService;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return detailService;
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(detailService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(AbstractHttpConfigurer::disable)
				.formLogin(login -> {
			login.loginPage("/login").permitAll();
		})
			.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/").permitAll();
			auth.anyRequest().authenticated();
		})
			.build();
	}

}
