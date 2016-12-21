package com.pris.task.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pris.task.model.Task;
import com.pris.task.model.TaskLog;
import com.pris.task.service.TaskLogService;
import com.pris.task.service.TaskService;

@Controller
public class PageController {
	private Logger log = Logger.getLogger(PageController.class);
	@Autowired
	private TaskService service;
	@Autowired
	private TaskLogService logService;
	@RequestMapping("/welcome")
	public String index(Model model){
		log.info("-----------------------------------------------------------------");
		Task t = new Task();
		t.setName("TTT");
		model.addAttribute("task", t);
		return "index";
	}
	@RequestMapping("/task/{id}")
	public ModelAndView taskInfo(@PathVariable String id){
		if(StringUtils.isBlank(id)){
			return new ModelAndView("index");
		}
		Task task = service.findOne(id);
		if(null == task){
			return new ModelAndView("index");
		}
		service.addCount(id);
		TaskLog log = new TaskLog();
		log.setTaskId(id);
		log.setTaskName(task.getName());
		log.setMode(1);
		log.setState(1);
		logService.addLog(log);
		ModelAndView view = new ModelAndView("task");
		view.addObject("task", task);
		return view;
	}
	@RequestMapping("/add")
	public String add(){
		log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		return "add";
	}
	@RequestMapping("/pick")
	@ResponseBody
	public Task pick(){
		return service.pickOne();
	}
}
