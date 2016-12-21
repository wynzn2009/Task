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
	private int count;

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

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Task [id=").append(id).append(", name=").append(name).append(", weight=").append(weight)
				.append(", state=").append(state).append(", count=").append(count).append("]");
		return builder.toString();
	}


}
