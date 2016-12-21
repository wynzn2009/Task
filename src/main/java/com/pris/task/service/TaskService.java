/**
 * 
 */
package com.pris.task.service;

import java.util.List;

import com.pris.task.model.Task;

/**
 * @author LO
 *
 */
public interface TaskService {
	Task pickOne();

	Task findOne(String id);
	
	List<Task> findAll();
	
	void addCount(String id);
	
	void updateTaskWeight(List<Task> list);
}
