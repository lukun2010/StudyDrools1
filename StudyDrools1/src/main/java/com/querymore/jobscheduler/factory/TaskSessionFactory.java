package com.querymore.jobscheduler.factory;

import org.drools.runtime.StatefulKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("TaskSessionFactory")
public class TaskSessionFactory {

	@Autowired
	private ApplicationContext applicationContext;
	
	public StatefulKnowledgeSession createTaskSession() {
		return (StatefulKnowledgeSession)applicationContext.getBean("taskSession");
	}
}
