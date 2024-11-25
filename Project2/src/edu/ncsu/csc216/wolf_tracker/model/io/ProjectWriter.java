package edu.ncsu.csc216.wolf_tracker.model.io;

import java.io.File;

import edu.ncsu.csc216.wolf_tracker.model.project.Project;


/**
 * the Writer class
 * Writes the project’s info to a file. 
 * Also writes the summary statistics to a file.
 * 
 * @author Leonel Mezatio
 */
public class ProjectWriter {
	
	/**
     * Writes the specified project to a file in a structured format.
     * The format includes all categories and tasks, using the Task's toString()
     * method for proper formatting.
     * 
     * @param projectFile the file to write the project data to
     * @param project the project to save
     * @throws IllegalArgumentException if an error occurs during saving
     */
	 public static void writeProjectFile(File projectFile, Project project) {
		// Have to implement later
	 }
	 
	 /**
	     * Writes the statistics of the specified project to a file in a formatted structure.
	     * The format is determined by AbstractTaskLog.toString(), and "All Tasks" is listed last.
	     * 
	     * @param statsFile the file to write the project statistics to
	     * @param project the project whose statistics are to be saved
	     * @throws IllegalArgumentException if an error occurs during saving
	     */
	 public static void writeStatsFile(File statsFile, Project project) {
		// Have to implement later
	 }
	
}
