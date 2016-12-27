/**
 * 
 */
package com.pris.handler;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pris.task.model.Task;
import com.pris.task.service.TaskService;

/**
 * @author LO
 *
 */
@Component
public class WeightHandler {
	private LinkedHashMap<String, Task> taskMap;
	private LinkedList<Task> taskList;
	private boolean sorted = false;
	private int total;
	@Autowired
	private TaskService service;
	public void init(List<Task> list) {
		this.taskMap = new LinkedHashMap<String, Task>(list.size());
		this.taskList = new LinkedList<Task>(list);
		this.total = 0;
		for (Task t : list) {
			total += t.getWeight();
			taskMap.put(t.getId(), t);
		}
		this.sortList();
	}

	private void sortList() {
		Collections.sort(taskList, new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				return o2.getWeight() - o1.getWeight();
			}
		});
		this.sorted = true;
	}
	private int getIndex(String id){
		Task t = this.taskMap.get(id);
		int index = taskList.indexOf(t);
		return index;
	}
	public Task getMax() {
		if (!sorted) {
			this.sortList();
		}
		return taskList.peekLast();
	}

	public Task getMin() {
		if (!sorted) {
			this.sortList();
		}
		return taskList.peekFirst();
	}

	public void addWeight(String id, int per) {
		Task task = this.taskMap.get(id);
		if(null == task){
			return;
		}
		int weight = task.getWeight();
		float avg = (float)(weight*per/100+1)/((float)taskList.size()-1);
		task.setWeight(weight+weight*per/100+1);
		weight = task.getWeight();
		for (Task t : taskList) {
			if(id.equals(t.getId())){
				continue;
			}
			int minus = Math.round(avg + (float)(t.getWeight() - weight)*avg/(float)weight);
			t.setWeight(t.getWeight()-minus);
		}
		this.sorted = false;
		this.sortList();
		service.updateTaskWeight(this.taskList);
	};

	public Task findInWeight(){
		this.init(service.findAll());
		Random random = new Random(System.nanoTime());
		int bean = random.nextInt(total);
		for(Task t: taskList){
			if(t.getWeight()>=bean){
				return t;
			}else{
				bean -= t.getWeight();
			}
		}
		return taskList.peekLast();
	}
	/**
	 * @return the taskList
	 */
	public List<Task> getTaskList() {
		return taskList;
	}

	/**
	 * @param taskList
	 *            the taskList to set
	 */
	public void setTaskList(LinkedList<Task> taskList) {
		this.taskList = taskList;
	}

	/**
	 * @return the sorted
	 */
	public boolean isSorted() {
		return sorted;
	}

	/**
	 * @param sorted
	 *            the sorted to set
	 */
	public void setSorted(boolean sorted) {
		this.sorted = sorted;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

}
