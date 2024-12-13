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
		this.list = (E[]) new Object[INIT_CAP];
	    this.size = 0;
	}
	
	/** 
	 * Adds an element to the end of the log list.
	 * 
	 * @param element the element to add to the log
     * @throws NullPointerException if the element is null
	 */
	public void addLog(E element) {
		if(element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		ensureCapacity(size + 1);
		list[size] = element;
	    size++;
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
		if(element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		
		if(idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		
		list[idx] = element;
	}

	/**
	 * Removes the element at a specified index.
     * 
     * @param idx the index of the element to remove
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if the index is out of bounds
	 */ 
	public E removeLog(int idx) {
		if(idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		E removed = list[idx];
		for(int i = idx; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = null;
		size--;
		return removed;
	}

	/** 
	 * Returns the element at the specified index.
     * 
     * @param idx the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
	 */
	public E getLog(int idx) {
		if(idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		return list[idx];
	}

	/** 
	 * Returns the number of elements in the log list.
     * 
     * @return the number of elements in the list
	 */
	public int size() {
		return size;
	}
	
	/**
     * This method will ensures the capacity of the log list.
     * 
     * @param size the required size
     */
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int size) {
	    if (size > list.length) {
	        int newSize = list.length * 2;                   // Double the size of the array
	        E[] temp = (E[]) new Object[newSize];            // Create a new empty array of type E 
	        System.arraycopy(list, 0, temp, 0, this.size);   // Copy of all element of that old array into the temp array 
	        list = temp;
	    }
	}
}
