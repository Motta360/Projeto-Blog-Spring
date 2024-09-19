package com.LucasMotta.ProjetoBlog.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.LucasMotta.ProjetoBlog.models.Post;
import com.LucasMotta.ProjetoBlog.services.PostService;

@Controller
public class PostController {
	
	@Autowired
	PostService postService;
	
	@GetMapping("/posts/{id}")
	public String posts(Model model, @PathVariable Long id) {
		Optional<Post> post = postService.findById(id);
		if(post.isPresent()) {
			Post obj = post.get();
			model.addAttribute("post",obj);
			return "post";
		}else {
			return "404";
		}
	}

}
