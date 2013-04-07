package com.querymore.jobscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.querymore.jobscheduler.model.Task;
import com.querymore.jobscheduler.service.TaskService;

@Controller
public class TaskSessionController {
	
	@Autowired
	@Qualifier("TaskServiceImpl")
	TaskService taskService;

	@RequestMapping(value="/task/{taskId}", method=RequestMethod.GET)
	public @ResponseBody Task getTaskInJSON(@PathVariable("taskId") Integer taskId) {
		return taskService.getTask(taskId);
	}
	
	@RequestMapping(value="/task", method=RequestMethod.POST)
	public @ResponseBody Task addTaskInJson(@RequestBody Task task) {
		return taskService.addTask(task);
	}
	
}
