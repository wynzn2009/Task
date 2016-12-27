package com.pris.task.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pris.task.model.Task;
import com.pris.task.service.TaskService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceImplTest {
	@Autowired
	private TaskService service;
	@Test
	public void testPickOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTaskWeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testPickInWeight() {
		int count = 0;
		for(int i=0;i<1000;i++){
			Task t = service.pickInWeight();
			if(t.getName().equalsIgnoreCase("reading")){
				count++;
			}
		}
		System.out.println(count);
	}
}
