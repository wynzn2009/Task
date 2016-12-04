/**
 * 
 */
package com.pris.task.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pris.task.dao.TaskDao;
import com.pris.task.model.Task;
import com.pris.util.UUIDUtil;

/**
 * @author LO
 *
 */
@RestController
public class BaseController {
	private Logger logger = Logger.getLogger(BaseController.class);
	@Autowired
	private TaskDao dao;
	
	
	
	@GetMapping("/**")
	public String base(){
		Object list = dao.findOne();
		logger.info(list);
		Task t = new Task();
		t.setId(UUIDUtil.uuid32());
		t.setName("Reading");
		t.setWeight(20);
		t.setState(1);
		dao.add(t);
		dao.find(t);
		dao.findAllTasks();
		dao.findById(t.getId());
		dao.update(t);
		dao.delete(t);
		dao.add(t);
		dao.deleteById(t.getId());
		return "Hello World";
	}
}
