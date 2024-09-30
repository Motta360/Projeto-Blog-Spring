package com.LucasMotta.ProjetoBlog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.LucasMotta.ProjetoBlog.models.User;
import com.LucasMotta.ProjetoBlog.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public Optional<User> findById(Long id){
		return userRepository.findById(id);
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User update(User user,Long id) {
		
		User obj = userRepository.getReferenceById(id);
		obj.setEmail(user.getEmail());
		obj.setPassword(user.getPassword());
		obj.setUserName(user.getUserName());
		
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}


}
