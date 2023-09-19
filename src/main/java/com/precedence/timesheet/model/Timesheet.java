package com.precedence.timesheet.model;

import java.time.LocalDate;

public class Timesheet {
	private String projectName;
	private String task;
	private LocalDate date;
	private int duration;
	private String description;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timesheet(String projectName, String task, LocalDate date, int duration, String description) {
		this.projectName = projectName;
		this.task = task;
		this.date = date;
		this.duration	 = duration;
		this.description = description;
	}

	public Timesheet() {
		super();
	}

}
