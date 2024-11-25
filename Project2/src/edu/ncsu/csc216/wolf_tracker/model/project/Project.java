package edu.ncsu.csc216.wolf_tracker.model.project;

import java.io.File;

import edu.ncsu.csc216.wolf_tracker.model.log.AbstractTaskLog;
import edu.ncsu.csc216.wolf_tracker.model.log.AllTasksLog;
import edu.ncsu.csc216.wolf_tracker.model.log.CategoryLog;
import edu.ncsu.csc216.wolf_tracker.model.task.Task;
import edu.ncsu.csc216.wolf_tracker.model.util.ISortedList;

/** 
 * The Project class tracks changes, and only one project can be active at a time.
 * 
 * @author Leonel Mezatio
 */
public class Project {
	
	// Instance Variables
	/** The name of the project */
    private String projectName;
    
    /** Indicates if the project has unsaved changes */
    private boolean isChanged;
    
    /** The current log for managing tasks */
    private AbstractTaskLog currentLog;
    
    /** The log containing all tasks in the project */
    private AllTasksLog allTasksLog;
    
    /** The list of category logs */
    private ISortedList<CategoryLog> categories;
    
    // Constructor
    /**
     * Constructs a project with a specified name.
     * 
     * @param projectName the name of the project
     * @throws IllegalArgumentException if the projectName is null, empty, or matches ALL_TASKS_NAME
     */
    public Project(String projectName) {
    	// Have to implement later
    }
    
    /**
     * Saves the project to the specified file.
     * Updates the isChanged flag to false.
     * 
     * @param projectFile the file to save the project to
     * @throws IllegalArgumentException if an error occurs during saving
     */
    public void saveProject(File projectFile) {
    	// Have to implement later
    }
    
    /**
     * Saves project statistics to the specified file.
     * 
     * @param statsFile the file to save the statistics to
     * @throws IllegalArgumentException if an error occurs during saving
     */
    public void saveStats(File statsFile) {
    	// Have to implement later
    }
    
    /**
     * Returns the name of the project.
     * 
     * @return the project name
     */
    public String getProjectName() {
    	// Have to implement later
    	return null;
    }
    
    /**
     * Sets the name of the project.
     * 
     * @param projectName the new name for the project
     * @throws IllegalArgumentException if projectName is null, empty, or matches ALL_TASKS_NAME
     */
    private void setProjectName (String projectName) {
    	// Have to implement later
    }
    
    /**
     * Returns whether the project has unsaved changes.
     * 
     * @return true if the project has unsaved changes, false otherwise
     */
    public boolean isChanged() {
    	return true;
    }
    
    /**
     * Sets the change status of the project.
     * 
     * @param changed the change status to set
     */
    public void setChanged(boolean changed) {
    	// Have to implement later
    }
    
    /**
     * Adds a new category log to the project, maintaining sorted order.
     * Sets the current log to the new CategoryLog and updates the isChanged flag.
     * 
     * @param categoryName the name of the category log
     * @throws IllegalArgumentException if categoryName is null, empty, matches ALL_TASKS_NAME, 
     *                                  or is a duplicate name
     */
    public void addCategoryLog(String categoryName) {
    	// Have to implement later
    }
    
    /**
     * Returns the names of all categories in the project, with "All Tasks" listed first.
     * 
     * @return an array of category names
     */
    public String[] getCategoryNames() {
    	// Have to implement later
    	return null;
    }
    
    /**
     * Sets the current task log to the specified log by name.
     * If no matching CategoryLog is found, the current log is set to the AllTasksLog.
     * 
     * @param logName the name of the log to set as current
     */
    public void setCurrentTaskLog(String logName) {
    	// Have to implement later
    }
    
    /**
     * Returns the current task log.
     * 
     * @return the current task log
     */
    public AbstractTaskLog getCurrentLog() {
    	// Have to implement later
    	return null;
    }
    
    /**
     * Edits the name of the current category log, maintaining sorted order.
     * 
     * @param categoryName the new name for the category log
     * @throws IllegalArgumentException if categoryName is invalid or duplicates another name
     */
    public void editCategoryLogName(String categoryName) {
    	// Have to implement later
    }
    
    /**
     * Removes the current category log from the project and sets the current log to the AllTasksLog.
     * Cascades delete to remove associated tasks in the AllTasksLog.
     * 
     * @throws IllegalArgumentException if the current log is AllTasksLog
     */
    public void removeCategoryLog() {
    	// Have to implement later
    }
    
    /**
     * Adds a task to the end of the current category log and to the AllTasksLog if the current log is a CategoryLog.
     * Updates the isChanged flag to true.
     * 
     * @param t the task to add
     */
    public void addTask(Task t) {
    	// Have to implement later
    }
    
    /**
     * Edits the task at the specified index in the current category log.
     * 
     * @param idx the index of the task to edit
     * @param taskName the new name for the task
     * @param taskDuration the new duration for the task
     * @param taskDetails the new details for the task
     */
    public void editTask(int idx, String taskName, int taskDuration, String taskDetails) {
    	// Have to implement later
    }
    
    /**
     * Removes the task at the specified index from both the current CategoryLog and the AllTasksLog.
     * Updates the isChanged flag to true.
     * 
     * @param idx the index of the task to remove
     */
    public void removeTask(int idx) {
    	// Have to implement later
    }
    
    /**
     * Returns a 2D String array of the most recent tasks in each CategoryLog.
     * Each row includes the task title, duration, and category name.
     * 
     * @return a 2D array of the most recent tasks for each category
     */
    public String[][] getMostRecentTasks(){
    	// Have to implement later
    	return null;
    }
}
