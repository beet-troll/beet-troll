package hw6;

import java.util.NoSuchElementException;

/**
 * This is a skeleton file for your homework. Complete the functions below. You
 * may also edit the function "main" to test your code.
 * 
 * You should not use any loops or recursions.  Your code needs to run in
 * constant time.  It is OK if your testing code has loops (like in checkInvariants).
 *
 * You must not add fields or static variables. As always, you must not change
 * the declaration of any method nor the name of the class or of this file.
 */

public class Deque<T> {

	private Node<T> first;	// A reference to the first item in the Dequeue (or
							// null if empty)
	private Node<T> last;	// A reference to the last item in the Dequeue (or
							// null if empty)
	private int N; 			// The number of items currently in the Dequeue

	static class Node<T> {
		
		public T item;			// The data stored at this node.
		public Node<T> next;	// The node to the right (or null if there is no
								// node to the right)
		public Node<T> prev;	// The node to the left (or null if there is no
								// node to the left)
	}

	/**
	 * Construct an empty <code>Deque</code>.
	 */
	public Deque() {
		first = null;
	    last = null;
	    N = 0;
	}

	/**
	 * Tests if the <code>Dequeue</code> is empty.
	 * 
	 * @return <code>true</code> if this <code>Deque</code> is empty and false
	 *         otherwise.
	 */
	public boolean isEmpty() {
        return N == 0;
	}

	/**
	 * Returns the number of items currently in this <code>Deque</code>.
	 * 
	 * @return the number of items currently in this <code>Deque</code>
	 */
	public int size() {
		return N;
	}

	/**
	 * Inserts an item into the front of this <code>Deque</code>.
	 * 
	 * @param item
	 *            the item to be inserted
	 */
	public void pushFront(T item) {
		if(item == null) {
			throw new java.lang.NullPointerException();
		}
		
		Node<T> first2 = first;
		first = new Node<T>();
		first.item = item;
		first.prev = null;
		first.next = first2; 
		
		if(isEmpty()) {
			last = first;
		}
		else {
			first2.prev = first;
		}
		N++;

      }

	/**
	 * 
	 * Inserts an item into the back of this <code>Deque</code>.
	 * 
	 * @param item
	 *            the item to be inserted
	 */
	public void pushBack(T item) {
		if(item == null) {
			throw new java.lang.NullPointerException();
		}
		Node<T> last2 = last;
		last = new Node<T>();
		last.item = item;;
		last.prev = last2;
		last.next = null;
		
		if(isEmpty()) {
			first = last;
		}
		else {
			last2.next = last;
		}
		N++;
	}

	/**
	 * Removes and returns the item at the front of this <code>Deque</code>.
	 * 
	 * @return the item at the front of this <code>Deque</code>.
	 * @throws NoSuchElementException if this <code>Deque</code> is empty.
	 */
	public T popFront() {
		if(isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		T item = first.item;
		first = first.next;
		if(first != null) {
			first.prev = null;
		}
		N--;
		
		if(isEmpty()) {
			last = null;
		}
		return item;
	}

	/**
	 * Removes and returns the item at the back of this <code>Deque</code>.
	 * 
	 * @return the item at the back this <code>Deque</code>.
	 * @throws NoSuchElementException if this <code>Deque</code> is empty.
	 */
	public T popBack() {
		if(isEmpty()) {
			throw new java.util.NoSuchElementException();
	}
		T item = last.item;
		last = last.prev;
		if(last != null) {
			last.next = null;
		}
		N--;
		
		if(isEmpty()) {
			first = null;
		}
		return item;
	}
}
