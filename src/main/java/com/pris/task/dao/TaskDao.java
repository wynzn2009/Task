/**
 * 
 */
package com.pris.task.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pris.task.model.Task;

/**
 * @author LO
 *
 */
@Mapper
public interface TaskDao {
	public void add(Task task);

	public void update(Task task);

	public void delete(Task task);

	public Task find(Task task);

	public void deleteById(String id);

	public Task findById(String id);
	
	public Task findOne();
	
	public List<Task> findAllTasks();
}
