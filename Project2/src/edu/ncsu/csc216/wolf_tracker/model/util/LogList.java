package edu.ncsu.csc216.wolf_tracker.model.util;

/**
 * A LogList class that implements the ILogList interface.
 * 
 * @param <E> the type of elements in this list
 * 
 * @author Leonel Mezatio
 */
public class LogList<E> implements ILogList<E> {

	// Instance variables
	/** Array to store elements in the log list */
	private E[] list;
	/** The current number of elements in the list */
	private int size;
	/** The initial capacity of the log list */
	private static final int INIT_CAP = 10;
	
	/** Constructs a new empty LogList */
	@SuppressWarnings("unchecked")
	public LogList() {
		// Have to implement later
	}
	
	/** 
	 * Adds an element to the end of the log list.
	 * 
	 * @param element the element to add to the log
     * @throws NullPointerException if the element is null
	 */
	public void addLog(E element) {
		// Have to implement later
	}

	/** 
	 * Sets the element at the specified index.
     * 
     * @param idx the index at which to set the element
     * @param element the element to set
     * @throws IndexOutOfBoundsException if the index is out of bounds
     * @throws NullPointerException if the element is null
	 */
	public void setLog(int idx, E element) {
		// Have to implement later
	}

	/**
	 * Removes the element at a specified index.
     * 
     * @param idx the index of the element to remove
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if the index is out of bounds
	 */ 
	public E removeLog(int idx) {
		// Have to implement later
		return null;
		
	}

	/** 
	 * Returns the element at the specified index.
     * 
     * @param idx the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
	 */
	public E getLog(int idx) {
		// Have to implement later
		return null;
	}

	/** 
	 * Returns the number of elements in the log list.
     * 
     * @return the number of elements in the list
	 */
	public int size() {
		// Have to implement later
		return 0;
	}
	
	/**
     * This method will ensures the capacity of the log list.
     * 
     * @param size the required size
     */
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int size) {
		// Have to implement later
	}
}
