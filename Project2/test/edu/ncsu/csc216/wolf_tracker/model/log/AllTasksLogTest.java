package edu.ncsu.csc216.wolf_tracker.model.log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/** 
 * Tests the functionality of the AllTasksLog class.
 * 
 * @author Leonel Mezatio
 */
public class AllTasksLogTest {

	/** Tests that the AllTasksLog name cannot be changed. */
    @Test
    public void testConstructorAndSetTaskLogName() {
    	AllTasksLog taskLog = new AllTasksLog();
    	
    	taskLog.setTaskLogName("All Tasks");
    	assertEquals("All Tasks", taskLog.getName());
    	
    	// Test invalid name (empty string and null)
    	assertThrows(IllegalArgumentException.class, () -> taskLog.setTaskLogName(""));
    	assertThrows(IllegalArgumentException.class, () -> taskLog.setTaskLogName(null));
    	assertThrows(IllegalArgumentException.class, () -> taskLog.setTaskLogName("Different Name"));
    }
}
