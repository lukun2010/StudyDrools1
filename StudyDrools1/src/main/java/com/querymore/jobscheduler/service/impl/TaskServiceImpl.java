package com.querymore.jobscheduler.service.impl;

import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;
import org.drools.runtime.rule.QueryResults;
import org.drools.runtime.rule.QueryResultsRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.querymore.jobscheduler.factory.TaskSessionFactory;
import com.querymore.jobscheduler.model.Task;
import com.querymore.jobscheduler.service.TaskService;

@Component("TaskServiceImpl")
public class TaskServiceImpl implements TaskService {

	private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);
	
	@Autowired
	@Qualifier("TaskSessionFactory")
	TaskSessionFactory taskSessionFactory;
	
	@Override
	public Task addTask(Task task) {
		// TODO Auto-generated method stub		
		StatefulKnowledgeSession statefulKnowledgeSession = taskSessionFactory.createTaskSession();
		
		FactHandle taskHandle = statefulKnowledgeSession.insert(task);
		
		log.info("addTask: taskId={}, taskName={}, lastRunTime={}, nextBeginTime={}",
			     new Object[] { task.getTaskId(), task.getTaskName(), task.getLastRunTime(), task.getNextBeginTime() } );
		
		return task;
	}

	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public void removeTask(Integer taskId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Task getTask(Integer taskId) {
		// TODO Auto-generated method stub
		log.info("getTask: taskId={}", new Object[] { taskId });
		
		StatefulKnowledgeSession statefulKnowledgeSession = taskSessionFactory.createTaskSession();
		
		QueryResults results = statefulKnowledgeSession.getQueryResults("task id equal to x", new Object[] { taskId });
		
		Task task = null;
		
		if (results.size() == 1) {
			QueryResultsRow row = results.iterator().next();
			task = (Task)row.get("task");
			
			log.info("getTask: taskId={}, taskName={}, lastRunTime={}, nextBeginTime={}",
				     new Object[] { task.getTaskId(), task.getTaskName(), task.getLastRunTime(), task.getNextBeginTime() } );
		} else {
			log.info("getTask Failed!");
		}
		
		return task;
		
	}

}
