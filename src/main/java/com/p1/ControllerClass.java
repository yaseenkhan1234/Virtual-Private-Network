package com.p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerClass {

	@Autowired
	AddClientRepo repo1;
	
	@Autowired
	AddPlacementRepo repo2;
	
	@Autowired
	RegisterRepo repo3;
	
	
	
	@RequestMapping("/home")
	
	public String home() {
		
			return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		
			return "Login";
	}
	
	@RequestMapping("/attendence")
	public String attendence() {
		
			return "attendence";
	}
	
	
	//redirect to marketing module
	@RequestMapping("/adminstration")
	public String adminstration() {
		
			return "adminstration";
	}
	
	//redirect to administration module
	@RequestMapping("/marketing")
	public String marketing() {
		
			return "adminstration1";
	}
	
	
	
	
	@RequestMapping("/addClient")
	public String addClient() {
		
			return "addClient";
	}
	
	@RequestMapping("/redirectRegister")
	public String redirectRegister() {
		
			return "Register";
	}
	

	@RequestMapping("/redirectaddplacement")
	public String redirectaddplacement() {
		
			return "AddPlacement";
	}
	
	
	@RequestMapping("/clientadd")
	public String clientadd(@ModelAttribute NewClientAdd add) {
		
		repo1.save(add);
		return "adminstration";
			
	}
	
	@RequestMapping("/register")
	public String register(@ModelAttribute RegisterClass add) {
		
		repo3.save(add);
		return "adminstration";
			
	}
	
	
	//AddPlacement
	@RequestMapping("/addPlacement")
	public String addPlacement(@ModelAttribute AddPlacement add) {
		
		repo2.save(add);
		return "adminstration";
			
	}
	
	
	@RequestMapping("/ClientList")
	public String clientList() {
		
		return "clientList";
	}
	
	//redirect to training module
	@RequestMapping("/Training")
	public String Training() {
		
		return "Training";
	}
	
	

	@RequestMapping("/ListofClients")
	public String ListofClients(@RequestParam("email") String email,@RequestParam("pass") String pass,Model model,HttpServletResponse res) throws IOException{
		
		List<NewClientAdd> list=repo1.findBymail(email);
		
		for(NewClientAdd client:list) {
			
			String mail=client.getMail();
			String dbpass=client.getPassword();
			
			if(email.equals(mail) && pass.equals(dbpass)) {
				model.addAttribute("list",list);
				return "ClientData";
			}else {
				PrintWriter out=res.getWriter();
				out.println("<h1>incorrect username and password</h1>");
			}
				
		}
		
		return "clientList";
	}
	
	//login forms
	@RequestMapping("/Loginconfirm")
	public String Loginconfirm(@RequestParam("login") String type,@RequestParam("pass") String pass,Model model) {
		
		
		
		if(type.equals("Administrator") && pass.equals("admin")) {
			
			List<NewClientAdd> li=repo1.findAll();
			
			List<RegisterClass> l1=repo3.findAll();
			model.addAttribute("li",li);
			model.addAttribute("li",l1);
			
			return "details";
			
		}
		
			return "attendence";
	}
	
	
}
