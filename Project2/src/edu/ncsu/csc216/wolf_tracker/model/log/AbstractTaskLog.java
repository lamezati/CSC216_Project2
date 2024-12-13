package edu.ncsu.csc216.wolf_tracker.model.log;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;
import edu.ncsu.csc216.wolf_tracker.model.util.ILogList;
import edu.ncsu.csc216.wolf_tracker.model.util.LogList;

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
		setTaskLogName(taskListName);
		this.tasks = new LogList<>();
	}
	
	/**
     * Returns the name of the task log.
     * 
     * @return the name of the task log
     */
	public String getName() {
		return taskLogName;
	}
	
	/**
     * Sets the name of the task log.
     * 
     * @param taskLogName the name of the task log
     * @throws IllegalArgumentException if the name is invalid
     */
	public void setTaskLogName(String taskLogName){
		if(taskLogName == null || taskLogName.isEmpty()) {
			throw new IllegalArgumentException("Invalid name.");
		}
		this.taskLogName = taskLogName;
	}
	
	/**
     * Returns the list of tasks in the log.
     * 
     * @return the list of tasks
     */
	public ILogList<Task> getTasks(){
		return tasks;
	}
	
	/**
     * Adds a task to the end of the task log.
     * 
     * @param t the task to add
     * @throws NullPointerException if the task is null
     */
	public void addTask(Task t) {
		tasks.addLog(t);
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
		tasks.setLog(idx, t);
	}
	
	/**
     * Removes the task at the specified index.
     * 
     * @param idx the index of the task to remove
     * @return the removed task
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
	public Task removeTask(int idx) {
		return tasks.removeLog(idx);
	}
	
	/**
     * Returns the task at the specified index.
     * 
     * @param idx the index of the task to retrieve
     * @return the task at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
	public Task getTask(int idx) {
		return tasks.getLog(idx);
	}
	
	/**
     * Returns the total number of tasks in the log.
     * 
     * @return the number of tasks in the log
     */
	public int getTaskCount() {
		return tasks.size();
	}
	
	/**
     * Returns the minimum duration of tasks in the log.
     * 
     * @return the minimum duration of tasks
     */
	public int getMinDuration() {
		if(tasks.size() == 0) {
			return 0;
		}
		int min = tasks.getLog(0).getTaskDuration();
		for(int i = 0; i < tasks.size(); i++) {
			int duration = tasks.getLog(i).getTaskDuration();
            if (duration < min) {
                min = duration;
            }
		}
		return min;
	}
	
	/**
     * Returns the maximum duration of tasks in the log.
     * 
     * @return the maximum duration of tasks
     */
	public int getMaxDuration() {
		if(tasks.size() == 0) {
			return 0;
		}
		int max = 0;
		for(int i = 0; i < tasks.size(); i++) {
			int duration = tasks.getLog(i).getTaskDuration();
            if (duration > max) {
                max = duration;
            }
		}
		return max;
	}
	
	/**
     * Returns the average duration of tasks in the log.
     * 
     * @return the average duration of tasks, rounded to the nearest tenth
     */
	public double getAvgDuration() {
		if(tasks.size() == 0) {
			return 0.0;
		}
		double total = 0;
		for(int i = 0; i < tasks.size(); i++) {
			total += tasks.getLog(i).getTaskDuration();
            
		}
		return (int)((total / tasks.size()) * 10.0 + 0.5) / 10.0;
	}
	
	/**
     * Returns the tasks in the log as a 2D array for display.
     * 
     * @return a 2D string array of tasks
     */
	public String[][] getTasksAsArray(){
		String[][] taskArray = new String[tasks.size()][3];
		for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.getLog(i);
            taskArray[i][0] = task.getTaskTitle();
            taskArray[i][1] = Integer.toString(task.getTaskDuration());
            taskArray[i][2] = task.getCategoryName();
        }
		return taskArray;
	}
	
	/**
     * Returns a string representation of the task log's summary statistics 
     * for printing to a file.
     * 
     * @return a string representation of the task log statistics
     */
	@Override
	public String toString() {
		String min = "";
		String max = "";
		String avg = "";
		
		if(getMinDuration() == 0) { 
			min = "";
		} else if(getMinDuration() != 0) {
			min = "" + getMinDuration();
		}
		if(getMaxDuration() == 0) { 
			max = "";
		} else if(getMaxDuration() != 0) { 
			max = "" + getMaxDuration();
		}
		if(getAvgDuration() == 0) { 
			avg = "";
		} else if(getAvgDuration() != 0) { 
			avg = "" + getAvgDuration();
		}
		
		return getName() + "," + getTaskCount() + "," + min + "," + max + "," + avg;
	}
}