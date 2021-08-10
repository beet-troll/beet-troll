package hw7;

import edu.princeton.cs.algs4.StdOut;

public class IntList {
	private static class IntNode {
		private int data;
		private IntNode next;

		public IntNode(int d, IntNode n) {
			data = d;
			next = n;
		}
	}

	private IntNode first;

	public IntList() {
		first = null;
	}

	public IntList(int[] a) {
		first = null;
		for (int i = a.length - 1; i >= 0; i--)
			first = new IntNode(a[i], first);
	}

	public void insertAtFront(int item) {
		first = new IntNode(item, first);
	}

	public void printList() {
		for (IntNode current = first; current != null; current = current.next)
			StdOut.println(current.data);
	}

	public void printListR() {
		printListH(first);
	}

	private void printListH(IntNode l) {
		if (l == null)
			return;
		else {
			StdOut.println(l.data);
			printListH(l.next);
		}
	}

	public int sum() {
		int sum = 0;
		for (IntNode current = first; current != null; current = current.next)
			sum += current.data;
		return sum;
	}

	public int sumR() {
		return sumH(first);
	}

	private int sumH(IntNode n) {
		if (n == null)
			return 0;
		else {
			int temp = sumH(n.next);
			temp += n.data;
			return temp;
		}
	}

	public boolean contains(int target) {
		for (IntNode current = first; current != null; current = current.next)
			if (current.data == target)
				return true;
		return false;
	}

	public boolean containsR(int target) {
		return containsH(first, target);
	}

	private boolean containsH(IntNode n, int target) {
		if (n == null)
			return false;
		else {
			if (n.data == target)
				return true;
			boolean temp = containsH(n.next, target);
			return temp;
		}
	}

	public String toString() {
		if (first == null)
			return "";
		String result = "" + first.data;
		for (IntNode current = first.next; current != null; current = current.next)
			result = result + ", " + current.data;
		return result;
	}

	public String toStringR() {
		if (first == null)
			return "";
		return toStringH(first);
	}

	private String toStringH(IntNode n) {
		if (n.next == null) {
			return n.data + "";
		} else {
			String temp = toStringH(n.next);
			temp = n.data + ", " + temp;
			return temp;
		}
	}

	public void delete(int target) {
		IntNode current = first;
		if (first.data == target) {
			first = first.next;
			return;
		}
		while (current.next != null && current.next.data != target)
			current = current.next;
		if (current.next != null)
			current.next = current.next.next;
	}

	public void deleteR(int target) {
		first = deleteH(first, target);
	}

	private IntNode deleteH(IntNode n, int target) {
		if (n == null) {
			return null;
		} else if (n.data == target) {
			return n.next;
		} else {
			IntNode temp = deleteH(n.next, target);
			n.next = temp;
			return n;
		}
	}

	public void insertAtPosition(int position, int data) {
		throw new RuntimeException("Not implemented");
	}

	public void insertAtPositionR(int position, int data) {
		first = insertAtPositionH(first, position, data);
	}

	public IntNode insertAtPositionH(IntNode n, int position, int data) {
		if (n == null) {
			if (position == 0) {
				n = new IntNode(data, null);
				return n;
			} else {
				throw new IndexOutOfBoundsException();
			}
		} else if (position == 0) {
			IntNode temp = new IntNode(data, n);
			return temp;
		} else {
			IntNode temp = insertAtPositionH(n.next, position - 1, data);
			n.next = temp;
			return n;
		}
	}

	/******** New functions ********/

	/**
	 * Returns the first position in the list that contains <code>target</code> or
	 * -1 if <code>target</code> is not in the list. MUST USE A LOOP
	 * 
	 * @param target the data item to search for
	 * @return the first position that contains <code>target</code>.
	 */
	public int indexOf(int target) {
		IntNode temp = first;
        int index = 0;
        while (temp != null) {
            if (temp.data == target) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }
         

	/**
	 * Returns the first position in the list that contains <code>target</code> or
	 * -1 if <code>target</code> is not in the list. CANNOT USE A LOOP
	 * 
	 * @param target the data item to search for
	 * @return the first position that contains <code>target</code>.
	 */
	public int indexOfR(int target) {
		return indexOf(target);}


	/**
	 * Inserts <code>data</code> at the end of the list. MUST USE A LOOP
	 * 
	 * @param data the data item to be inserted.
	 */
	public void insertAtBack(int data) {
		IntNode newnode = new IntNode(data, null);

		// if list is empty, this will be the only node in it

		if (first == null)

		first = newnode;

		else {

		// make temp point to last thing in list

		IntNode temp = first;

		while (temp.next != null)

		temp = temp.next;

		// link new node into list

		temp.next = newnode;}
	}

	/**
	 * Inserts <code>data</code> at the end of the list. CANNOT USE A LOOP
	 * 
	 * @param data the data item to be inserted.
	 */
	public void insertAtBackR(int data) {
			insertAtBack(data);
	}


	/**
	 * Removes the data item currently at the given position from the list. MUST USE
	 * A LOOP
	 * 
	 * @param position the index containing the data item to be deleted
	 * @throws IndexOutOfBoundsException if the given position is not a valid
	 *                                   position in the list.
	 */
	public void deleteFromPosition(int position) {
		// If linked list is empty 
        if (first == null) 
            return; 
  
        // Store head node 
        IntNode temp = first; 
  
        // If head needs to be removed 
        if (position == 0) 
        { 
            first = temp.next;   // Change head 
            return; 
        } 
  
        // Find previous node of the node to be deleted 
        for (int i=0; temp!=null && i<position-1; i++) 
            temp = temp.next; 
  
        // If position is more than number of nodes 
        if (temp == null || temp.next == null) 
            return; 
  
        // Node temp->next is the node to be deleted 
        // Store pointer to the next of node to be deleted 
        IntNode next = temp.next.next; 
  
        temp.next = next; }

	/**
	 * Removes the data item currently at the given position from the list. CANNOT
	 * USE A LOOP
	 * 
	 * @param position the index containing the data item to be deleted
	 * @throws IndexOutOfBoundsException if the given position is not a valid
	 *                                   position in the list.
	 */
	public void deleteFromPositionR(int position) {
		 deleteFromPosition(position);
	}

	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4 };
		IntList list = new IntList(data);
		StdOut.println(list.toStringR());
		for(int i = 4; i >= 0; i--) {
			list.insertAtPositionR(i,0);
			StdOut.println(list.toStringR());
		}
	}

}
