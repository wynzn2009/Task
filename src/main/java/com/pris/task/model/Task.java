/**
 * 
 */
package com.pris.task.model;

import org.apache.ibatis.type.Alias;

/**
 * @author LO
 *
 */
@Alias("Task")
public class Task {
	private String id;
	private String name;
	private int weight;
	private int state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Task [id=").append(id).append(", name=").append(name).append(", weight=").append(weight)
				.append(", state=").append(state).append("]");
		return builder.toString();
	}

}
