package sg.edu.nus.sms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
@RequestMapping("/student")
public class StuController {
	
	@GetMapping("/stugrades")
	public String grades() {
		
		return "stugrades";
	}

}
