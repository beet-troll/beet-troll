package hw4;

public class LinkedIntSet {
	private static class Node {
		private int data;
		private Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node first;

	public LinkedIntSet() {
		first = null;
	}

	public int size() {
		int counter = 0;
		for (Node current = first; current != null; current = current.next)
			counter++;
		return counter;
	}

	public boolean contains(int i) {
		for (Node current = first; current != null; current = current.next) {
			if (current.data == i)
				return true;
		}
		return false;
	}

	// Ignore this equals method. Write the code for the other equals method.
	public boolean equals(Object otherObject) {
		LinkedIntSet other = (LinkedIntSet) otherObject;
		return this.equals(other);
	}

	/***************************** NEW METHODS ************************************/

	/**
	 * Adds <code>element</code> to this set if it is not already present and
	 * returns <code>true</code>. If <code>element</code> is already present, the
	 * set is unchanged and <code>false</code> is returned.
	 * 
	 * @param element the element to be added
	 * @return <code>true</code> if the element was added and <code>false</code>
	 *         otherwise.
	 */
	public boolean addElement(int element) {
		Node newNode = new Node(element, null);
		if(this.first == null) 
			{this.first = newNode ;
			return true;}
		else 
			{Node temp = first ;
			Node prev = temp ;
			while(temp!=null) {
				if(temp.data == element)
					return false;
				prev = temp ;
				temp = temp.next ;}
			prev.next = newNode;
			return true;}}
	/**
	 * Removes an element from the set.
	 * 
	 * @param element the element to be removed
	 * @return <code>true</code> if the element was removed and <code>false</code>
	 *         otherwise.
	 */
	public boolean removeElement(int element) {
		Node prev = null, curr = first;
	    while(curr != null && !(curr.data==(element)))
	    	{prev = curr;
	    	curr = curr.next;}
	     	if(curr == null) 
	           {return false;}
	     	if(curr == first) 
	           {first = first.next;}
	       else
	           {prev.next = curr.next;}
	       return true;}

	/**
	 * Returns true if <code>this</code> and <code>other</code> have the same
	 * elements and false otherwise.
	 * 
	 * @param other the set to compare against for equality
	 * @return true if <code>this</code> and <code>other</code> have the same
	 *         elements and false otherwise.
	 */
	public boolean equals(LinkedIntSet other) {
		   Node firstList = this.first;
		   Node secondList = other.first;
		   if(firstList == null && secondList == null)
		        return true;
		   if(this.size() != other.size())
		        return false;
		   while(firstList != null && secondList != null){
		        if(firstList.data != secondList.data)
		            return false;
		        firstList = firstList.next;
		        secondList = secondList.next;
		    }
		   return true;
		  }

	 /** Changes the set so that it is equal the union of itself and
	 * <code>other</code>.
	 * 
	 * @param other the set to union with
	 */
	public void union(LinkedIntSet other) {
			for (Node current = other.first; current != null; current = current.next)
			this.addElement(current.data);
			}
	
	/**
	 * Changes the set so that is equal the intersection of itself and
	 * <code>other</code>.
	 * 
	 * @param other the set to intersect with
	 */
	
	public void intersect(LinkedIntSet other) {			 
		for (Node current = first; current != null; current = current.next)
		{
		if(!other.contains(current.data))
		{
		this.removeElement(current.data);
	    }}}}
