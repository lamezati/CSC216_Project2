package edu.ncsu.csc216.wolf_tracker.model.util;

/**
 * A sorted list class that implements the ISortedList interface.
 * 
 * @param <E> the type for sorted list
 * 
 * @author Leonel Mezatio
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {
	/** The size of the list */
    private int size;
    
    /** The front node of the linked list */
    private ListNode front;
	
	/**
     * Constructs an empty SortedList.
     */
    public SortedList() {
    	front = null;
        size = 0;
    	// Have to implement later
    }

    /** 
     * Adds an element to the list, maintaining sorted order.
     * 
     * @param element the element to add
     * @throws NullPointerException if the element is null
     * @throws IllegalArgumentException if the element is a duplicate
     */
    public void add(E element) {
    	// Have to implement later
    }

    /** 
     * Removes the element at the specified index.
     * 
     * @param idx the index of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public E remove(int idx) {
    	// Have to implement later
        return null;
    }

    /**
     * Checks if the list contains the specified element.
     * 
     * @param element the element to check for
     * @return true if the element is in the list, false otherwise
     */
    public boolean contains(E element) {
    	// Have to implement later
        return false;
    }

    /** 
     * Returns the element at the specified index.
     * 
     * @param idx the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public E get(int idx) {
    	// Have to implement later
        return null;
    }

    /** 
     * Returns the number of elements in the sorted list.
     * 
     * @return the number of elements in the list
     */
    public int size() {
    	// Have to implement later
        return 0;
    }

    /**
     * Node class for implementing the linked list structure.
     */
    private class ListNode {
        /** The data stored in this node */
        private E data;
        
        /** The next node in the list */
        private ListNode next;
        
        /**
         * Constructs a ListNode with the given data.
         * @param data the data for the node
         * @param next the next node in the list
         */
        public ListNode(E data, ListNode next) {
        	// Have to implement later
        }
    }
}
