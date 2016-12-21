/**
 * 
 */
package com.pris.task.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pris.task.dao.MonitorDao;
import com.pris.task.dao.TaskDao;

/**
 * @author LO
 *
 */
@RestController
public class BaseController {
	private Logger logger = Logger.getLogger(BaseController.class);
	@Autowired
	private TaskDao dao;
	@Autowired
	private MonitorDao monitorDao;
}
