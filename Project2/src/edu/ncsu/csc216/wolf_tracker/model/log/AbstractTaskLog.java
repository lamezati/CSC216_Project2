package edu.ncsu.csc216.wolf_tracker.model.log;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;
import edu.ncsu.csc216.wolf_tracker.model.util.ILogList;

/** 
 * An abstract base class for managing a log of tasks, providing common functionality 
 * for task management.
 * 
 * @author Leonel Mezatio
 */
public abstract class AbstractTaskLog {
	/** The name of the task log */
	private String taskLogName;
	/** List of tasks in the log */
	private ILogList<Task> tasks;
	
	/**
     * Constructs an abstract task log with a specified name.
     * @param taskListName the name of the task log
     * @throws IllegalArgumentException if the name is null or empty
     */
	public AbstractTaskLog(String taskListName) {
		// Have to implement later
	}
	
	/**
     * Returns the name of the task log.
     * 
     * @return the name of the task log
     */
	public String getName() {
		// Have to implement later
		return null;
	}
	
	/**
     * Sets the name of the task log.
     * 
     * @param taskLogName the name of the task log
     * @throws IllegalArgumentException if the name is invalid
     */
	public void setTaskLogName(String taskLogName){
		// Have to implement later
	}
	
	/**
     * Returns the list of tasks in the log.
     * 
     * @return the list of tasks
     */
	public ILogList<Task> getTasks(){
		// Have to implement later
		return null;
	}
	
	/**
     * Adds a task to the end of the task log.
     * 
     * @param t the task to add
     * @throws NullPointerException if the task is null
     */
	public void addTask(Task t) {
		// Have to implement later
	}
	
	/**
     * Sets the task at the specified index.
     * 
     * @param idx the index to set the task at
     * @param t the task to set
     * @throws NullPointerException if the task is null
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
	public void setTask(int idx, Task t) {
		// Have to implement later
	}
	
	/**
     * Removes the task at the specified index.
     * 
     * @param idx the index of the task to remove
     * @return the removed task
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
	public Task removeTask(int idx) {
		// Have to implement later
		return null;
	}
	
	/**
     * Returns the task at the specified index.
     * 
     * @param idx the index of the task to retrieve
     * @return the task at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
	public Task getTask(int idx) {
		// Have to implement later
		return null;
	}
	
	/**
     * Returns the total number of tasks in the log.
     * 
     * @return the number of tasks in the log
     */
	public int getTaskCount() {
		// Have to implement later
		return 0;
	}
	
	/**
     * Returns the minimum duration of tasks in the log.
     * 
     * @return the minimum duration of tasks
     */
	public int getMinDuration() {
		// Have to implement later
		return 0;
	}
	
	/**
     * Returns the maximum duration of tasks in the log.
     * 
     * @return the maximum duration of tasks
     */
	public int getMaxDuration() {
		// Have to implement later
		return 0;
	}
	
	/**
     * Returns the average duration of tasks in the log.
     * 
     * @return the average duration of tasks, rounded to the nearest tenth
     */
	public double getAvgDuration() {
		// Have to implement later
		return 0;
	}
	
	/**
     * Returns the tasks in the log as a 2D array for display.
     * 
     * @return a 2D string array of tasks
     */
	public String[][] getTasksAsArray(){
		// Have to implement later
		return null;
	}
	
	/**
     * Returns a string representation of the task log's summary statistics 
     * for printing to a file.
     * 
     * @return a string representation of the task log statistics
     */
	@Override
	public String toString() {
		return null;
	}
}