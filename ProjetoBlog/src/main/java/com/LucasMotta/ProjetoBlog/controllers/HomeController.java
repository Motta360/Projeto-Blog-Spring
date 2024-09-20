package com.LucasMotta.ProjetoBlog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.LucasMotta.ProjetoBlog.models.Post;
import com.LucasMotta.ProjetoBlog.models.User;
import com.LucasMotta.ProjetoBlog.repositories.PostRepository;


@Controller
public class HomeController {
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping("/")
	public String home(Model model,User user) {
		List<Post> posts = postRepository.findAll();
		model.addAttribute("posts", posts);
		
		return "home";
		
	}

}
	

