package com.codingdojo.demo.controladores;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.demo.modelos.User;
import com.codingdojo.demo.servicios.AppService;

@Controller
public class ControladorUsuarios {

	@Autowired 
	private AppService servicio;
	
	@GetMapping("/registration")
	public String register(@ModelAttribute("user") User user) {
		return "register.jsp";
	}
	
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "register.jsp";
		} else {
			servicio.saveWithUserRole(user);
			return "redirect:/login";
		}		
	}
		
	@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false)String error, Model model) {
		if(error != null) {
			model.addAttribute("errorMessage", "Credenciales inválidas, favor revisar tu información");
		}	
		return "login.jsp";	
	}
	
	@RequestMapping(value= {"/", "/home"})
	public String home(Principal principal, Model model) {
		String username = principal.getName(); // Regresa el username del usuario que inició sesion
		User currentUser = servicio.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		return "home.jsp";
	}
	
}
