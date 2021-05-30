package com.cos.photogramstart.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

@Controller	
public class AuthController {

	@Autowired
	private final AuthService authService;
	
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
 	
	@GetMapping("/auth/signin")
	public String signinForm() {
		return "auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String signupForm() {
		return "auth/signup";
	}
	
	
	
	@PostMapping("/auth/signup")
	public @ResponseBody String signup(@Valid SignupDto signupDto, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				System.out.println(error.getDefaultMessage());
				System.out.println("--");
				System.out.println("--");
				System.out.println("--");
			}
			return "오류";
		} else {
			//User user = signupDto.toEntity();
			
			User user = new User(signupDto.getUsername(), 
								signupDto.getPassword(), 
								signupDto.getEmail(),
								signupDto.getName()
								);
			
			User userEntity = authService.회원가입(user);
			
			
			
			System.out.println(userEntity);
			return "auth/signin";
		}
 		
	}
	
	
}
