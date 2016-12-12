/**
 * 
 */
package com.pris.task.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pris.task.model.Monitor;
import com.pris.task.model.Task;

/**
 * @author LO
 *
 */
@Mapper
public interface MonitorDao {
	public void add(Monitor monitor);
//
//	public void update(Monitor monitor);
//
//	public void delete(Monitor monitor);
//
//	public Task find(Monitor monitor);
//
//	public void deleteById(String id);
//
//	public Task findById(String id);
//	
//	public Task findOne();
//	
//	public List<Task> findAllTasks();
	
	public List<Monitor> findById(Monitor monitor);
}
