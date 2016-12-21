/**
 * 
 */
package com.pris.task.dao;

import org.apache.ibatis.annotations.Mapper;

import com.pris.task.model.TaskLog;

/**
 * @author LO
 *
 */
@Mapper
public interface TaskLogDao {
	void addInfo(TaskLog log);
}
