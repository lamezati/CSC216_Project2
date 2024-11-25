package edu.ncsu.csc216.wolf_tracker.model.log;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;

/** 
 * Represents a category-specific log for tasks, where tasks are grouped 
 * by category.
 * 
 * @author Leonel Mezatio
 */
public class CategoryLog extends AbstractTaskLog implements Comparable<CategoryLog> {

	/**
     * Constructs a CategoryLog with the specified name.
     * 
     * @param taskListName the name of the category log
     * @throws IllegalArgumentException if the name is invalid
     */
	public CategoryLog(String taskListName) {
		// Have to implement later
		super(taskListName);
	}

	/** 
	 * Compares this CategoryLog with another based on name, ignoring case.
     * 
     * @param o the other CategoryLog to compare
     * @return a negative integer, zero, or a positive integer as this CategoryLog
     *         is less than, equal to, or greater than the specified CategoryLog
	 */
	@Override
	public int compareTo(CategoryLog o) {
		// Have to implement later
		return 0;
	}
	
	/**
     * Overrides setTask to add a task to the category log. 
     * The CategoryLog is also added to the Task.
     * 
     * @param idx the index at which to set the task
     * @param t the task to set
     * @throws NullPointerException if the task is null
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
	@Override
	public void setTask(int idx, Task t) {
		// Have to implement later
	}
	
	/**
     * Overrides addTask to add a task to the end of the category log.
     * The CategoryLog is also added to the Task.
     * 
     * @param t the task to add
     * @throws NullPointerException if the task is null
     */
	public void addTask(Task t) {
		// Have to implement later
	}
}
