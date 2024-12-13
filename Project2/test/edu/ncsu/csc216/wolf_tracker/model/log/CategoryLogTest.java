package edu.ncsu.csc216.wolf_tracker.model.log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;

/** 
 * Tests the functionality of the CategoryLog class.
 * 
 * @author Leonel Mezatio
 */
public class CategoryLogTest {

	/**
     * Tests adding a task to the category log.
     */
    @Test
    public void testAddTask() {
        CategoryLog categoryLog = new CategoryLog("Design");
        
        // Test add Task
        Task task1 = new Task("Task 1", 30, "Details 1");
        Task task2 = new Task("Task 2", 45, "Details 2");
        
        // Test adding task to the categoryLog
        categoryLog.addTask(task1);
        categoryLog.addTask(task2);
        
        // Check the size
        assertEquals(2, categoryLog.getTaskCount());
        assertEquals("Task 1", categoryLog.getTask(0).getTaskTitle());
        assertEquals("Task 2", categoryLog.getTask(1).getTaskTitle());
        
        // Check that the category was added to the tasks
        assertEquals("Design", task1.getCategoryName());
        assertEquals("Design", task2.getCategoryName());
        
        // Test adding null task
    	assertThrows(NullPointerException.class, () -> categoryLog.addTask(null));
    }
    
    /**
     * Tests Setting a task to the category log.
     */
    @Test
    public void testSetTask() {
        CategoryLog categoryLog = new CategoryLog("Design");
        
        // Test create a new Task
        Task task1 = new Task("Task 1", 30, "Details 1");
        
        // Test adding task to the categoryLog
        categoryLog.addTask(task1);
        
        // Test Setting a Task
        Task task2 = new Task("Task 2", 45, "Details 2");
        categoryLog.setTask(0, task2);
        
        // Check the size
        assertEquals(1, categoryLog.getTaskCount());
        assertEquals("Task 2", categoryLog.getTask(0).getTaskTitle());
        assertEquals("Design", task2.getCategoryName());
        
        // Test adding null task
    	assertThrows(NullPointerException.class, () -> categoryLog.setTask(0, null));
    	assertThrows(IndexOutOfBoundsException.class, () -> categoryLog.setTask(-1, task1));
    	assertThrows(IndexOutOfBoundsException.class, () -> categoryLog.setTask(1, task1));
    }
    
    /**
     * Tests CompareTo for the category log.
     */
    @Test
    public void testCompareTo() {
        CategoryLog categoryLog1 = new CategoryLog("DesignA");
        CategoryLog categoryLog2 = new CategoryLog("DesignB");
        CategoryLog categoryLog3 = new CategoryLog("DesignA");
        
        // Test Compare
        assertTrue(categoryLog1.compareTo(categoryLog2) < 0);
        assertTrue(categoryLog2.compareTo(categoryLog1) > 0);
        assertEquals(0, categoryLog3.compareTo(categoryLog1));
        
        // Test Comparing null object
    	assertThrows(NullPointerException.class, () -> categoryLog1.compareTo(null));
    }
    
    /**
     * Test setTaskLogName() method.
     */
    @Test
    public void testSetTaskLogName() {
    	CategoryLog categoryLog1 = new CategoryLog("Design");
    	
    	categoryLog1.setTaskLogName("Javadoc");
    	assertEquals("Javadoc", categoryLog1.getName());
    	
    	// Test invalid name (empty string and null)
    	assertThrows(IllegalArgumentException.class, () -> categoryLog1.setTaskLogName(""));
    	assertThrows(IllegalArgumentException.class, () -> categoryLog1.setTaskLogName(null));
    }

}
