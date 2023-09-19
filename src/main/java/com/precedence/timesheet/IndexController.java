package com.precedence.timesheet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.precedence.timesheet.model.Timesheet;

@Controller
public class IndexController {
	public static final List<Timesheet> TIMESHEETS;
	public static final List<String> PROJECTS;
	public static final List<String> TASKS;
	static {
		TIMESHEETS = new ArrayList<Timesheet>();
		TIMESHEETS.add(new Timesheet("UserPortal", "DBconnection", LocalDate.now(), 8, "Urgenct"));
		PROJECTS = new ArrayList<String>();
		PROJECTS.add("Proj 1");
		PROJECTS.add("Proj 4");
		PROJECTS.add("Proj 2");
		PROJECTS.add("Proj 3");
		TASKS = new ArrayList<String>();
		TASKS.add("Task 1");
		TASKS.add("Task 2");
		TASKS.add("Task 3");
	}

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("Timesheets", TIMESHEETS);
		Timesheet timesheet = new Timesheet();
		model.addAttribute("timesheet", timesheet);
		model.addAttribute("Projects", PROJECTS);
		model.addAttribute("Tasks", TASKS);
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

	@RequestMapping(value = "/addTimesheet")
	public String addTimesheet(@ModelAttribute("timesheet") Timesheet timesheet, BindingResult result, Model model) {
		TIMESHEETS.add(timesheet);
		model.addAttribute("Timesheets", TIMESHEETS);
		return "index";
	}

}
