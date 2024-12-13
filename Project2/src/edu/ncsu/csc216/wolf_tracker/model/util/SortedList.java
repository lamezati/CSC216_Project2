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
    }

    /** 
     * Adds an element to the list, maintaining sorted order.
     * 
     * @param element the element to add
     * @throws NullPointerException if the element is null
     * @throws IllegalArgumentException if the element is a duplicate
     */
    public void add(E element) {
    	if(element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
    	
    	if (contains(element)) {
            throw new IllegalArgumentException("Cannot add duplicate element.");
        }
		
    	if (front == null || element.compareTo(front.data) < 0) {
            front = new ListNode(element, front);
        } else {
        	ListNode current = front;
        	
        	while (current.next != null && current.next.data.compareTo(element) < 0) {
                current = current.next;
            }
        	
        	current.next = new ListNode(element, current.next);
        }
    	size++;
    }

    /** 
     * Removes the element at the specified index.
     * 
     * @param idx the index of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public E remove(int idx) {
    	if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
    	
    	E removed;
        if (idx == 0) {
            removed = front.data;
            front = front.next;
        } else {
            ListNode current = front;
            for (int i = 0; i < idx - 1; i++) {
                current = current.next;
            }
            removed = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return removed;
    }

    /**
     * Checks if the list contains the specified element.
     * 
     * @param element the element to check for
     * @return true if the element is in the list, false otherwise
     */
    public boolean contains(E element) {
    	ListNode current = front;
    	
        while (current != null) {
        	
            if (current.data.compareTo(element) == 0) {
                return true;
            }
            current = current.next;
        }
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
    	if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
    	
        ListNode current = front;
        for (int i = 0; i < idx; i++) {
            current = current.next;
            
        }
        return current.data;
    }

    /** 
     * Returns the number of elements in the sorted list.
     * 
     * @return the number of elements in the list
     */
    public int size() {
        return size;
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
        	this.data = data;
        	this.next = next;
        }
    }
}
