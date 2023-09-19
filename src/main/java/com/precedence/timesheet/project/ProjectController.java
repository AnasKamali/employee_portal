package com.precedence.timesheet.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {
	@RequestMapping("/projects/form")
	public String projectForm() {
		return "projectForm";
	}

}
