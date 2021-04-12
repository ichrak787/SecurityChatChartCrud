package com.entite.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
	@GetMapping("/home")
	public String home(){
		return "this is home page, welcome to the  kindergarten website , have fun";
	}
    @GetMapping("/admin")
    public String admin(){
    	return "this admin page";
    }
}
