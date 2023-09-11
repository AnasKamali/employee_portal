package com.precedence.timesheet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/login")
	public String login(Model model) {
		Employee emp = new Employee();
		model.addAttribute("emp", emp);
		return "login";
	}

	@PostMapping(value = "/authenticate")
	public String authenticate(@ModelAttribute("emp") Employee emp, BindingResult result, Model model) {
		if (emp.getUserName().equals("mak") && emp.getPassword().equals("123")) {
			return "index";
		}
		ObjectError error = new ObjectError("globalError", "User not exists Or password missmatch");
		result.addError(error);
		return "login";
	}

	@GetMapping(value = "/register")
	public String register() {
		return "register";
	}

}
