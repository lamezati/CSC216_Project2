package edu.ncsu.csc216.wolf_tracker.model.task;

import edu.ncsu.csc216.wolf_tracker.model.log.CategoryLog;

/**
 * The task class that represents the task in the wolf tracker system
 * 
 * @author Leonel Mezatio
 */
public class Task {

	// Instance Variables
	/** Title of the task */
	private String taskTitle;
	/** Duration of the task */
	private int taskDuration;
	/** Additional details of the task */
	private String taskDetails;
	/** Category to which this task belongs */
	private CategoryLog category;
	
	 // Constructor
	/**
	 * Constructs a task with a specified title, duration, and details.
	 * 
	 * @param taskTitle the title of the task
	 * @param taskDuration the duration of the task
	 * @param taskDetails additional details of the task
	 * @throws IllegalArgumentException if taskTitle is null or empty
	 * @throws IllegalArgumentException if taskDuration is less than 1
	 * @throws IllegalArgumentException if taskDetails is null or empty
	 */
	public Task(String taskTitle, int taskDuration, String taskDetails) {
		setTaskTitle(taskTitle);
        setTaskDuration(taskDuration);
        setTaskDetails(taskDetails);
        this.category = null;
	}
	
	// Getters and Setters
	/**
	 * Returns the title of the task.
	 * 
	 * @return the title of the task
	 */
	public String getTaskTitle() {
		return taskTitle;
	}
	
	/**
     * Sets the title of the task after validating it.
     * 
     * @param taskTitle the title of the task
     * @throws IllegalArgumentException if taskTitle is null or empty
     */
	public void setTaskTitle(String taskTitle) {
		if(taskTitle == null || taskTitle.isEmpty()) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskTitle = taskTitle;
	}
	
	/**
     * Returns the duration of the task.
     * 
     * @return the duration of the task
     */
	public int getTaskDuration() {
		return taskDuration;
	}
	
	/**
     * Sets the duration of the task after validating it.
     * 
     * @param taskDuration the duration of the task in minutes
     * @throws IllegalArgumentException if taskDuration is less than 1
     */
	public void setTaskDuration(int taskDuration) {
		if(taskDuration < 1) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskDuration = taskDuration;
	}
	
	/**
     * Returns the additional details of the task.
     * 
     * @return the details of the task
     */
	public String getTaskDetails() {
		return taskDetails;
	}
	
	/**
     * Sets the additional details of the task after validating it.
     * 
     * @param taskDetails the details of the task
     * @throws IllegalArgumentException if taskDetails is null or empty
     */
	public void setTaskDetails(String taskDetails) {
		if(taskDetails == null || taskDetails.isEmpty()) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskDetails = taskDetails;
	}
	
	/**
     * Sets the category of this task if it is currently unassigned.
     * 
     * @param category the category to assign to this task
     * @throws IllegalArgumentException if category is null or the task already has an assigned category
     */
	public void addCategory(CategoryLog category) {
		if(category == null || this.category != null) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.category = category;
	}
	
	/**
     * Returns the name of the category assigned to this task, 
     * or an empty string if no category is assigned.
     * 
     * @return the name of the category or an empty string if the category is null
     */
	public String getCategoryName() {
		if(category == null) {
			return "";
		} else {
			return category.getName();
		}
	}
	
	/**
     * Returns a string representation of the Task suitable for file output.
     * 
     * @return a string representation of the Task, including its title, duration, details, and category name
     */
	@Override
	public String toString() {
		return "* " + taskTitle + "," + taskDuration + "," + getCategoryName() + "\n" + taskDetails;
	}
}
