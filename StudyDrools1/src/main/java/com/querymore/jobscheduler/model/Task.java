package com.querymore.jobscheduler.model;

import java.util.Date;

public class Task {

	private Integer taskId;
	private String taskName;
	private Date lastRunTime;
	private Date nextBeginTime;
	
	public Task(Integer taskId, String taskName, Date lastRunTime, Date nextBeginTime) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.lastRunTime = lastRunTime;
		this.nextBeginTime = nextBeginTime;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getLastRunTime() {
		return lastRunTime;
	}

	public void setLastRunTime(Date lastRunTime) {
		this.lastRunTime = lastRunTime;
	}

	public Date getNextBeginTime() {
		return nextBeginTime;
	}

	public void setNextBeginTime(Date nextBeginTime) {
		this.nextBeginTime = nextBeginTime;
	}
	
}
