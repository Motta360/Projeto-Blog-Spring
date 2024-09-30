package com.LucasMotta.ProjetoBlog.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.LucasMotta.ProjetoBlog.models.User;
import com.LucasMotta.ProjetoBlog.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(email);
		
		if(user.isPresent()) {
			var userObj = user.get();
			return org.springframework.security.core.userdetails.User.builder().username(userObj.getEmail()).password(userObj.getPassword()).build();
		}else {
			throw new UsernameNotFoundException(email);
		}
		
	}
	

}
