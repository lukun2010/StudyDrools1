package com.querymore.jobscheduler.service;

import java.util.Date;

import com.querymore.jobscheduler.model.Task;

public interface TaskService {
	
	Task getTask(Integer taskId);
	Task addTask(Task task);
	Task updateTask(Task task);
	void removeTask(Integer taskId);
	
}
