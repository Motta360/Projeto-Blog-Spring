package com.LucasMotta.ProjetoBlog.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.LucasMotta.ProjetoBlog.models.User;
import com.LucasMotta.ProjetoBlog.services.UserService;

@Controller
public class UserControler {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users/{id}")
	public String user(Model model, @PathVariable Long id) {
		Optional<User> obj = userService.findById(id);
		
		if(obj.isPresent()) {
			User user = obj.get();
			model.addAttribute("user", user);
			return "user";
		}else {
			return "404";
		}
		
	}

}
