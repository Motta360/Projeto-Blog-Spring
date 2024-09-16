package com.LucasMotta.ProjetoBlog.configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.LucasMotta.ProjetoBlog.models.Post;
import com.LucasMotta.ProjetoBlog.models.User;
import com.LucasMotta.ProjetoBlog.services.PostService;
import com.LucasMotta.ProjetoBlog.services.UserService;

@Configuration
public class Config implements CommandLineRunner {
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(1l, "lucas", "123", "lucas@gmail.com");
		
		userService.save(u1);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy | HH:mm");
		Post p1 = new Post(1l, "Post 1", "Primeiro Texto excrito", LocalDateTime.parse("01/01/2024 | 15:07", fmt), u1);
		postService.save(p1);
		
	}
	

}
