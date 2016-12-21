/**
 * 
 */
package com.pris.task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pris.task.dao.TaskLogDao;
import com.pris.task.model.TaskLog;
import com.pris.task.service.TaskLogService;

/**
 * @author LO
 *
 */
@Service
public class TaskLogServiceImpl implements TaskLogService {
	@Autowired
	private TaskLogDao dao;
	/**
	 * @see com.pris.task.service.TaskLogService#addLog(com.pris.task.model.TaskLog)
	 */
	@Override
	public void addLog(TaskLog log) {
		dao.addInfo(log);
	}

}
