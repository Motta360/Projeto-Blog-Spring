package com.LucasMotta.ProjetoBlog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	

}
