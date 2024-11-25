package edu.ncsu.csc216.wolf_tracker.model.log;

/**
 * this class overrides the behavior for seeting the log's name
 * 
 * @author Leonel Mezatio
 */
public class AllTasksLog extends AbstractTaskLog {

	/**
	 * final value for the alltasksname
	 */
	public static final String ALL_TASKS_NAME = "All Tasks";
	
	/**
	 * the all tasks log constructor
	 */
	public AllTasksLog() {
		super(ALL_TASKS_NAME);
	}
	
	/**
     * Overrides setTaskLogName to ensure the name is not editable.
     * @param taskLogName the name of the task log
     * @throws IllegalArgumentException if the name is different from ALL_TASKS_NAME
     */
	@Override
	public void setTaskLogName(String taskLogName) {
		// Have to implement later
	}
	
}
