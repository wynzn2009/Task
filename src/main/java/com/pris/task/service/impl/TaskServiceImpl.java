package com.pris.task.service.impl;

import java.util.List;
import java.util.Random;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pris.handler.WeightHandler;
import com.pris.task.dao.TaskDao;
import com.pris.task.model.Task;
import com.pris.task.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskDao dao;
	@Autowired
	private WeightHandler w;
	@Override
	public Task pickOne() {
		List<Task> list = dao.findAllTasks();
		Random r = new Random(System.nanoTime());
		return list.get(r.nextInt(list.size()));
	}

	@Override
	public Task findOne(String id) {
		Task task = dao.findById(id);
		return task;
	}

	@Override
	public void addCount(String id) {
		dao.addCount(id);
	}

	@Override
	public void updateTaskWeight(List<Task> list) {
		if(CollectionUtils.isEmpty(list)){
			return;
		}
		dao.updateTaskWeight(list);
	}

	@Override
	public List<Task> findAll() {
		return dao.findAllTasks();
	}

	@Override
	public Task pickInWeight() {
		Task t = w.findInWeight();
		System.out.println(t);
		return t;
	}
}
