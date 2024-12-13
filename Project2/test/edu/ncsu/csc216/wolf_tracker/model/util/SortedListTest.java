package edu.ncsu.csc216.wolf_tracker.model.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SortedListTest {

	/** Tests adding elements to the list. */
	@Test
	public void testAdd() {
		SortedList<Integer> list = new SortedList<Integer>();
    	
    	// Adding elements
    	list.add(1);
    	list.add(4);
    	list.add(3);
    	list.add(2);
    	list.add(5);
        
        // Verify the order
        assertEquals(5, list.size());
        
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
        
        // Test adding a null element
        assertThrows(NullPointerException.class, () -> list.add(null));
        // Test adding a duplicate element
        assertThrows(IllegalArgumentException.class, () -> list.add(2));
	}
	
	/** Test removing elements to the list. */
	@Test
	public void testRemove() {
		SortedList<Integer> list = new SortedList<Integer>();
    	
    	// Adding elements
    	list.add(1);
    	list.add(4);
    	list.add(3);
    	list.add(2);
    	list.add(5);
        
        // Test removing elements at different indices
        assertEquals(5, list.size());
        
        assertEquals(3, list.remove(2));
        assertEquals(4, list.size());
        
        assertEquals(5, list.remove(3));
        assertEquals(3, list.size());
        
        assertEquals(2, list.remove(1));
        assertEquals(2, list.size());
        
        assertEquals(1, list.remove(0));
        assertEquals(1, list.size());
        
        assertEquals(4, list.remove(0));
        assertEquals(0, list.size());
        
        // Test removing from an empty list
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        // Test removing at wrong index
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-2));
	}
	
	/** Test the contains() method on a list. */
	@Test
	public void testContains() {
		SortedList<Integer> list = new SortedList<Integer>();
    	
        // Add elements and test contains()
    	list.add(10);
    	list.add(20);
    	list.add(30);

        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertTrue(list.contains(30));
        assertFalse(list.contains(4));
	}
	
	/** Test the get() method on a list. */
	@Test
	public void testGet() {
		SortedList<Integer> list = new SortedList<Integer>();
    	
        // Add elements and test contains()
    	list.add(10);
    	list.add(20);
    	list.add(30);

    	assertEquals(10, list.get(0));
    	assertEquals(30, list.get(2));
    	assertEquals(20, list.get(1));
    	
    	// Test index out of bounds
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
        
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-2));
	}
}
