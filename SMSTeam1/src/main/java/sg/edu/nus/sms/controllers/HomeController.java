package sg.edu.nus.sms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import sg.edu.nus.sms.model.User;

@Controller
@SessionAttributes("user")
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value="/authenticate", path="/authenticate",method= {RequestMethod.GET, RequestMethod.POST}, produces="text/html")
	public String getAuthentication(@ModelAttribute("user") User user, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()) {
			return "login";
		}
		
		System.out.println(user.getUserName());
		
		if(user.getUserName().equalsIgnoreCase("Student"))
			return "forward:/student/stugrades";
		else if(user.getUserName().equalsIgnoreCase("Admin"))
			return "forward:/admin/studentlist";
		else if(user.getUserName().equalsIgnoreCase("Faculty"))
			return "forward:/faculty/assignedcourses";
		else
			return "login";
	}
}
