package sg.edu.nus.sms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
@RequestMapping("/faculty")
public class FacController {
	
	@GetMapping("/assignedcourses")
	public String assignedCourses() {
		
		return "assignedcourses";
	}

}
