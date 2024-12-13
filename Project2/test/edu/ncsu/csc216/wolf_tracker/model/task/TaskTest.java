package edu.ncsu.csc216.wolf_tracker.model.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tracker.model.log.CategoryLog;

/**
 * Tests the functionality of the Task class
 * 
 * @author Leonel Mezatio
 */
public class TaskTest {

	/** Tests setting a valid task title. */
    @Test
    public void testSetTaskTitle() {
    	Task task = new Task("Test", 60, "Task details");
    	
    	assertEquals("Test", task.getTaskTitle());
    	
    	// Test Invalid
    	assertThrows(IllegalArgumentException.class, () -> new Task("", 60, "Detail"));
    	assertThrows(IllegalArgumentException.class, () -> new Task(null, 60, "Detail"));
    }
    
    /** Tests TaskDuration() method. */
    @Test
    public void testDuration() {
    	Task task = new Task("Test", 60, "Task details");
    	
    	assertEquals(60, task.getTaskDuration());
    	
    	// Test setting a new duration
    	task.setTaskDuration(90);
    	assertEquals(90, task.getTaskDuration());
    	
    	// Test Invalid
    	assertThrows(IllegalArgumentException.class, () -> task.setTaskDuration(0));
    	assertThrows(IllegalArgumentException.class, () -> task.setTaskDuration(-5));
    }
    
    /** Tests SetTaskDetails() method. */
    @Test
    public void testSetTaskDetails() {
    	Task task = new Task("Test", 60, "Task details");
    	
    	assertEquals("Task details", task.getTaskDetails());
    	
    	// Test updating the Task details
    	task.setTaskDetails("Updated details");
    	assertEquals("Updated details", task.getTaskDetails());
    	
    	// Test Invalid
    	assertThrows(IllegalArgumentException.class, () -> task.setTaskDetails(null));
    	assertThrows(IllegalArgumentException.class, () -> task.setTaskDetails(""));
    }
    
    /** Tests AddCategory() method. */
    @Test
    public void testAddCategory() {
    	Task task = new Task("Test", 60, "Task details");
    	CategoryLog category = new CategoryLog("Design");
    	
    	// Test setting a category to the task
    	task.addCategory(category);
        assertEquals("Design", task.getCategoryName());
    	
    	// Test Invalid
    	assertThrows(IllegalArgumentException.class, () -> task.addCategory(null));
    	//assertThrows(IllegalArgumentException.class, () -> task.addCategory(""));
    }
    
    /** Tests toString() method. */
    @Test
    public void testToString() {
    	Task task = new Task("Test", 60, "Task details");
    	
    	String expectedString = "* Test,60,\nTask details";
        assertEquals(expectedString, task.toString());
    	
    	// Test updating the Task details
        CategoryLog category = new CategoryLog("Javadoc");
        task.addCategory(category);
    	
    	// Test to see update
        String updatedString = "* Test,60,Javadoc\nTask details";
        assertEquals(updatedString, task.toString());
    }
}
