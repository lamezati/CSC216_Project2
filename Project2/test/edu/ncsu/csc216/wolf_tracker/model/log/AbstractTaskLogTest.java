package edu.ncsu.csc216.wolf_tracker.model.log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;
import edu.ncsu.csc216.wolf_tracker.model.util.ILogList;

/** 
 * Tests the functionality of the AbstractTaskLog class through its subclasses.
 * 
 * @author Leonel Mezatio
 */
public class AbstractTaskLogTest {
	
	/** Test for the constructor and setTaskLogName() method. */
    @Test
    public void testConstructorAndSetTaskLogName() {
    	AbstractTaskLog taskLog = new AllTasksLog();
    	
    	taskLog.setTaskLogName("All Tasks");
    	assertEquals("All Tasks", taskLog.getName());
    	
    	// Test invalid name (empty string and null)
    	assertThrows(IllegalArgumentException.class, () -> taskLog.setTaskLogName(""));
    	assertThrows(IllegalArgumentException.class, () -> taskLog.setTaskLogName(null));
    	assertThrows(IllegalArgumentException.class, () -> taskLog.setTaskLogName("Different Name"));
    }
    
    /** Test for the addTask() method. */
    @Test
    public void testAddTask() {
    	AbstractTaskLog taskLog = new AllTasksLog();
    	Task task1 = new Task("Task 1", 30, "Details 1");
        Task task2 = new Task("Task 2", 45, "Details 2");
    	
        // Test adding tasks
        taskLog.addTask(task1);
        taskLog.addTask(task2);
        
        assertEquals(2, taskLog.getTaskCount());
        
        assertEquals("Task 1", taskLog.getTask(0).getTaskTitle());
        assertEquals("Task 2", taskLog.getTask(1).getTaskTitle());
        
    	// Test invalid name (null)
    	assertThrows(NullPointerException.class, () -> taskLog.addTask(null));
    }
    
    /** Test for the setTask() method. */
    @Test
    public void testSetTask() {
    	AbstractTaskLog taskLog = new AllTasksLog();
    	Task task1 = new Task("Task 1", 30, "Details 1");
        Task task2 = new Task("Task 2", 45, "Details 2");
    	
        // Test adding tasks
        taskLog.addTask(task1);
        
        assertEquals("Task 1", taskLog.getTask(0).getTaskTitle());
        assertEquals("Details 1", taskLog.getTask(0).getTaskDetails());
        assertEquals(30, taskLog.getTask(0).getTaskDuration());
        
        // Track the size
        assertEquals(1, taskLog.getTaskCount());
        
        // Test setting task at index 0
        taskLog.setTask(0, task2);
        assertEquals("Task 2", taskLog.getTask(0).getTaskTitle());
        assertEquals("Details 2", taskLog.getTask(0).getTaskDetails());
        assertEquals(45, taskLog.getTask(0).getTaskDuration());
        
        // Track the size
        assertEquals(1, taskLog.getTaskCount());
        
    	// Test invalid name (null)
    	assertThrows(NullPointerException.class, () -> taskLog.setTask(0, null));
    	
    	// Test setting task at invalid index
    	assertThrows(IndexOutOfBoundsException.class, () -> taskLog.setTask(-1, task1));
    	assertThrows(IndexOutOfBoundsException.class, () -> taskLog.setTask(1, task1));
    }
    
    /** Test for the removeTask() method. */
    @Test
    public void testRemoveTask() {
    	AbstractTaskLog taskLog = new AllTasksLog();
    	Task task1 = new Task("Task 1", 30, "Details 1");
        Task task2 = new Task("Task 2", 45, "Details 2");
    	
        // Test adding tasks
        taskLog.addTask(task1);
        taskLog.addTask(task2);
        
        // Test setting task at index 0 and 1
        assertEquals("Task 1", taskLog.getTask(0).getTaskTitle());
        assertEquals("Details 1", taskLog.getTask(0).getTaskDetails());
        assertEquals(30, taskLog.getTask(0).getTaskDuration());
        
        assertEquals("Task 2", taskLog.getTask(1).getTaskTitle());
        assertEquals("Details 2", taskLog.getTask(1).getTaskDetails());
        assertEquals(45, taskLog.getTask(1).getTaskDuration());
        
        // Track the size
        assertEquals(2, taskLog.getTaskCount());
        
        Task removedTask = taskLog.removeTask(1);
        assertEquals("Task 2", removedTask.getTaskTitle());
        assertEquals(1, taskLog.getTaskCount());
    	
    	// Test setting task at invalid index
    	assertThrows(IndexOutOfBoundsException.class, () -> taskLog.removeTask(-1));
    	assertThrows(IndexOutOfBoundsException.class, () -> taskLog.removeTask(1));
    }
    
    /** Test for the getTask() method. */
    @Test
    public void testGetTask() {
    	AbstractTaskLog taskLog = new AllTasksLog();
    	Task task1 = new Task("Task 1", 30, "Details 1");
        Task task2 = new Task("Task 2", 45, "Details 2");
    	
        // Test adding tasks
        taskLog.addTask(task1);
        taskLog.addTask(task2);
        
        // Test getting task
        Task task = taskLog.getTask(0);
        assertEquals("Task 1", task.getTaskTitle());
        assertEquals("Details 1", task1.getTaskDetails());
        assertEquals(30, task1.getTaskDuration());
        
        Task task22 = taskLog.getTask(1);
        assertEquals("Task 2", task22.getTaskTitle());
        assertEquals("Details 2", task22.getTaskDetails());
        assertEquals(45, task22.getTaskDuration());
        
        // Track the size
        assertEquals(2, taskLog.getTaskCount());
        
        ILogList<Task> tasks = taskLog.getTasks();
        
        assertEquals(2, tasks.size());
    	
        // Verify that they are equals
        assertEquals(task1, tasks.getLog(0));
        assertEquals(task2, tasks.getLog(1));
    }
    
    /** Test for the getDuration() method. */
    @Test
    public void testGetDuration() {
    	AbstractTaskLog taskLog = new AllTasksLog();
    	Task task1 = new Task("Task 1", 30, "Details 1");
        Task task2 = new Task("Task 2", 5, "Details 2");
        Task task3 = new Task("Task 3", 45, "Details 3");
        
        // No Tasks = 0 Duration
    	assertEquals(0, taskLog.getMaxDuration());
    	assertEquals(0, taskLog.getMinDuration());
    	assertEquals(0.0, taskLog.getAvgDuration(), 0.001);
    	
        // Test adding tasks
        taskLog.addTask(task1);
        taskLog.addTask(task2);
        taskLog.addTask(task3);
        
        assertEquals(45, taskLog.getMaxDuration());
        
        assertEquals(5, taskLog.getMinDuration());
        
        assertEquals(26.7, taskLog.getAvgDuration());
    }
    
    /** Test for the getTasksAsArray() method. */
    @Test
    public void testGetTasksAsArray() {
    	AbstractTaskLog taskLog = new AllTasksLog();
    	Task task1 = new Task("Task 1", 30, "Details 1");
        Task task2 = new Task("Task 2", 5, "Details 2");
        Task task3 = new Task("Task 3", 45, "Details 3");
        
        // Test adding tasks
        taskLog.addTask(task1);
        taskLog.addTask(task2);
        taskLog.addTask(task3);

        String[][] taskArray = taskLog.getTasksAsArray();
        assertEquals(3, taskArray.length);
        assertEquals("Task 1", taskArray[0][0]);
        assertEquals("30", taskArray[0][1]);
        assertEquals(task1.getCategoryName(), taskArray[0][2]);
        assertEquals("Task 2", taskArray[1][0]);
        assertEquals("5", taskArray[1][1]);
        assertEquals(task2.getCategoryName(), taskArray[1][2]);
        assertEquals("Task 3", taskArray[2][0]);
        assertEquals("45", taskArray[2][1]);
        assertEquals(task3.getCategoryName(), taskArray[2][2]);
    }
    
    /** Test for the toString() method. */
    @Test
    public void testToString() {
    	AbstractTaskLog taskLog = new AllTasksLog();
    	// Now test for empty
    	String expectedOutput1 = "All Tasks,0,,,";
        assertEquals(expectedOutput1, taskLog.toString());
        
        taskLog.addTask(new Task("Task 1", 30, "Details 1"));
        taskLog.addTask(new Task("Task 2", 5, "Details 2"));
        taskLog.addTask(new Task("Task 3", 45, "Details 3"));

        String expectedOutput2 = "All Tasks,3,5,45,26.7";
        assertEquals(expectedOutput2, taskLog.toString());
        
        // Now test for empty
        
    }
}
