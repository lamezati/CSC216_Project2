package edu.ncsu.csc216.wolf_tracker.model.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests the functionality of the LogList class.
 * 
 * @author Leonel Mezatio
 */
public class LogListTest {

	/** Tests adding elements to the log list and verify it. */
	@Test
	public void testAddLog() {
		LogList<Integer> logList = new LogList<>();
    	
    	// Test adding elements
    	logList.addLog(1);
    	logList.addLog(4);
    	logList.addLog(3);
    	logList.addLog(2);
    	logList.addLog(5);
        
    	// Verify the order
    	assertEquals(5, logList.size());
        
        assertEquals(1, logList.getLog(0));
        assertEquals(4, logList.getLog(1));
        assertEquals(3, logList.getLog(2));
        assertEquals(2, logList.getLog(3));
        assertEquals(5, logList.getLog(4));
        
        // Test adding a null element
        assertThrows(NullPointerException.class, () -> logList.addLog(null));
	}
	
	/** Tests setting log elements to the log list and verify it. */
	@Test
	public void testSetLog() {
		LogList<Integer> logList = new LogList<>();
    	
    	// Test adding elements
    	logList.addLog(1);
    	logList.addLog(4);
    	logList.addLog(3);
    	logList.addLog(2);
    	logList.addLog(5);
        
    	// Verify the size
    	assertEquals(5, logList.size());
    	
    	// Test setting an element at index
    	logList.setLog(1, 20);
    	assertEquals(20, logList.getLog(1));
    	
    	assertEquals(5, logList.size());
    	
        
        // Test adding a null element
        assertThrows(NullPointerException.class, () -> logList.setLog(1, null));
        
        // Test setting an element at an invalid index
        assertThrows(IndexOutOfBoundsException.class, () -> logList.setLog(-1, 50));
        assertThrows(IndexOutOfBoundsException.class, () -> logList.setLog(5, 50));
	}
	
	/** Tests removing log elements to the log list and verify it. */
	@Test
	public void testRemoveLog() {
		LogList<Integer> logList = new LogList<>();
    	
    	// Test adding elements
    	logList.addLog(1);
    	logList.addLog(4);
    	logList.addLog(3);
    	logList.addLog(2);
    	logList.addLog(5);
        
    	// Verify the size
    	assertEquals(5, logList.size());
    	
    	// Test removing elements
        assertEquals(5, logList.size());
        
        assertEquals(3, logList.removeLog(2));
        assertEquals(4, logList.size());
        
        assertEquals(5, logList.removeLog(3));
        assertEquals(3, logList.size());
        
        assertEquals(4, logList.removeLog(1));
        assertEquals(2, logList.size());
        
        assertEquals(1, logList.removeLog(0));
        assertEquals(1, logList.size());
        
        assertEquals(2, logList.removeLog(0));
        assertEquals(0, logList.size());
        
        // Test removing an element at an invalid index
        assertThrows(IndexOutOfBoundsException.class, () -> logList.removeLog(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> logList.removeLog(0));
	}
	
	/** Tests getLog elements to the log list and verify it. */
	@Test
	public void testGetLog() {
		LogList<Integer> logList = new LogList<>();
    	
    	// Test adding elements
    	logList.addLog(1);
    	logList.addLog(4);
    	logList.addLog(3);
    	logList.addLog(2);
    	logList.addLog(5);
        
    	// Verify the size
    	assertEquals(5, logList.size());
    	
    	// Test getting elements at invalid index
        assertThrows(IndexOutOfBoundsException.class, () -> logList.getLog(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> logList.getLog(5));
	}
	
	@Test
	public void testEnsureCapacityCompleteCoverage() {
		
		LogList<Integer> logList = new LogList<>();
		
		// Fill the list to its initial capacity
	    for (int i = 0; i < 10; i++) {
	        logList.addLog(i);
	    }
	    
	    // Manually trigger ensureCapacity with a size much larger than double the current capacity
	    // Current capacity = 10; list.length * 2 = 20; required size = 50
	    for (int i = 10; i < 50; i++) {
	        logList.addLog(i);
	    }

	    // Verify the list can accommodate the large size
	    assertEquals(50, logList.size());
	    assertEquals((Integer) 49, logList.getLog(49)); // Verify the last element
	}
	
	@Test
	public void testEnsureCapacityForNewSizeLessThanRequiredSize() {
	    LogList<Integer> logList = new LogList<>();
	    
	    // Fill the list to its initial capacity
	    for (int i = 0; i < 10; i++) {
	        logList.addLog(i);
	    }
	    
	    // Trigger ensureCapacity with a size much larger than double the current capacity
	    // Current capacity = 10; list.length * 2 = 20; required size = 50
	    for (int i = 10; i < 50; i++) {
	        logList.addLog(i);
	    }

	    // Verify the list can accommodate the large size
	    assertEquals(50, logList.size());
	    assertEquals((Integer) 49, logList.getLog(49)); // Verify the last element
	}

}
