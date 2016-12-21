/**
 * 
 */
package com.pris.handler;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pris.TaskApplicationTests;
import com.pris.task.model.Task;
import com.pris.task.service.TaskService;

/**
 * @author LO
 *
 */
public class WeightHandlerTest extends TaskApplicationTests{
	@Autowired
	private TaskService service;
	@Autowired
	private WeightHandler handler;
	private Random r = new Random(System.nanoTime());
	/**
	 * Test method for {@link com.pris.handler.WeightHandler#addWeight(java.lang.String, int)}.
	 */
	@Test
	public void testAddWeight() {
		for(int i=0;i<1;i++){
			List<Task> taskList = service.findAll();
			Task t = taskList.get(r.nextInt(taskList.size()));
			handler.init(taskList);
			System.out.println(t);
			handler.addWeight(t.getId(), 10);
			System.out.println(t);
		}
	}

}
