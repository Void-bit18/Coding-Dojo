package com.java.spring.beltreview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.spring.beltreview.models.LoginUser;
import com.java.spring.beltreview.models.User;
import com.java.spring.beltreview.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	// import service
	@Autowired UserService userService;
	
	// render logreg form
	@GetMapping("/")
	public String renderLogregForm(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "logreg.jsp";
	}
	
	// process register
		@PostMapping("/register")
		public String processRegister(@Valid @ModelAttribute("newUser") User newUser, 
				BindingResult result, Model model, HttpSession session) {
				//calling the service
			User registeredUser = userService.register(newUser, result);
				if(result.hasErrors()) {
						model.addAttribute("newLogin", new LoginUser());
						return "logreg.jsp";
					}else {
						//register
						session.setAttribute("userId", registeredUser.getId());
						session.setAttribute("userName", registeredUser.getUserName());
						return "redirect:/dash";
					}
				}
		
		@PostMapping("/login")
		public String processLogin(@Valid @ModelAttribute("newLogin")LoginUser newLogin,
				BindingResult result, Model model, HttpSession session) {
			User loggedUser = userService.login(newLogin, result);
			if(result.hasErrors()) {
				model.addAttribute("newUser", new User());
				return "logreg.jsp";
			}else {
				//register
				session.setAttribute("userId", loggedUser.getId());
				session.setAttribute("userName", loggedUser.getUserName());
				return "redirect:/dash";
			}
		}
		
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}

}
