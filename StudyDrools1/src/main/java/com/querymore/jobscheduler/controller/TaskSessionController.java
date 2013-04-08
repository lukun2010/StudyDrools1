package com.querymore.jobscheduler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger log = LoggerFactory.getLogger(TaskSessionController.class);
	
	@Autowired
	@Qualifier("TaskServiceImpl")
	TaskService taskService;

	@RequestMapping(value="/task/{taskId}", method=RequestMethod.GET)
	public @ResponseBody Task getTaskInJSON(@PathVariable("taskId") Integer taskId) {
		log.info("Call getTaskInJSON");
		return taskService.getTask(taskId);
	}
	
	@RequestMapping(value="/task", method=RequestMethod.POST)
	public @ResponseBody Task addTaskInJSON(@RequestBody Task task) {
		log.info("Call addTaskInJSON");
		return taskService.addTask(task);
	}
	
}
