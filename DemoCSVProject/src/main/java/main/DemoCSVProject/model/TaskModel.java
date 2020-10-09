package main.DemoCSVProject.model;


import java.math.BigDecimal;
import java.text.NumberFormat;

import com.opencsv.bean.CsvBindByName;

public class TaskModel {
	@CsvBindByName(column = "STATUS")
	private String status;
	
	private static float totalFixedCost=0, totalActualHours=0;
	
	@CsvBindByName(column = "PRIORITY")
	private String priority;

	@CsvBindByName(column = "DEADLINE")
	private String deadline;
	
	@Override
	public String toString() {
		return "TaskModel [status=" + status + ", priority=" + priority + ", deadline=" + deadline + ", taskName="
				+ taskName + ", assignee=" + assignee + ", description=" + description + ", deliverable=" + deliverable
				+ ", done=" + done + ", fixedCost=" + fixedCost + ", estimatedHours=" + estimatedHours
				+ ", actualHours=" + actualHours + ", ProjectName=" + ProjectName + "]";
	}

	@CsvBindByName(column = "TASK NAME")
	private String taskName;

	@CsvBindByName(column = "ASSIGNEE")
	private String assignee;
	
	@CsvBindByName(column = "DESCRIPTION")
	private String description;
	
	@CsvBindByName(column = "DELIVERABLE")
	private String deliverable;

	@CsvBindByName(column = "% DONE")
	private String done;

	@CsvBindByName(column = "FIXED COST")
	private String fixedCost;
	
	@CsvBindByName(column = "EST. HRS")
	private float estimatedHours;
	
	@CsvBindByName(column = "ACTUAL HRS")
	private float actualHours;
	
	@CsvBindByName(column = "Project Name")
	private String ProjectName;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline){
		this.deadline=deadline;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeliverable() {
		return deliverable;
	}

	public void setDeliverable(String deliverable) {
		this.deliverable = deliverable;
	}

	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}

	public String getFixedCost() {
		return fixedCost;
	}

	public void setFixedCost(String fixedCost) {
		this.fixedCost = fixedCost;
		String cost = this.fixedCost.replace("$", "");
		cost = cost.replace(",", "");
		this.totalFixedCost += Float.parseFloat(cost);
	}

	public float getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(float estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public float getActualHours() {
		return actualHours;
	}

	public void setActualHours(float actualHours) {
		this.actualHours = actualHours;
		this.totalActualHours += this.actualHours;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	public static float getTotalFixedCost() {
		return totalFixedCost;
	}

	public static float getTotalActualHours() {
		return totalActualHours;
	}

	
	
	
}
