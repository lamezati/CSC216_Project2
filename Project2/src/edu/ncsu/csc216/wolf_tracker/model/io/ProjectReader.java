package edu.ncsu.csc216.wolf_tracker.model.io;

import java.io.File;

import edu.ncsu.csc216.wolf_tracker.model.project.Project;

/**
 * Handles reading project data from a file. Provides a method to load a project
 * from a specified file, validating and processing data into a Project instance.
 * 
 * @author Leonel Mezatio
 */
public class ProjectReader {
	/**
     * Reads a project from the specified file. The file should contain
     * a project name, categories, and tasks in a structured format.
     * Invalid entries are ignored.
     * 
     * @param file the file to read the project from
     * @return the Project instance read from the file
     * @throws IllegalArgumentException if the file cannot be loaded or has an invalid format
     */
	public static Project readProjectFile(File file) {
		// Have to implement later
		return null;
	}
	
	/**
     * Processes a task for the specified project by parsing task details.
     * This method handles both the task information and any associated description lines.
     * 
     * @param project the project to which the task is added
     * @param str the task details as a single string
     */
	private static void processTask(Project project, String str) {
		// Have to implement later
	}
}
