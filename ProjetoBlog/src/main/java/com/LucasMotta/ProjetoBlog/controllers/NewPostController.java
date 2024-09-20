package com.LucasMotta.ProjetoBlog.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.LucasMotta.ProjetoBlog.models.Post;
import com.LucasMotta.ProjetoBlog.models.User;
import com.LucasMotta.ProjetoBlog.services.PostService;
import com.LucasMotta.ProjetoBlog.services.UserService;

@Controller
public class NewPostController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/newPost")
	public String getNewPostPage(Model model) {
		Post post = new Post();
		model.addAttribute("post",post);
		return "newPost";
	}
	
	@PostMapping("/newPost")
	public String savePost(@ModelAttribute Post post) {
		post.setCriadoEm(LocalDateTime.now());
		post.setUser(userService.findById(1l).get());
		postService.save(post);
		
		return "redirect:/posts/" + post.getId();
		
	}

}
