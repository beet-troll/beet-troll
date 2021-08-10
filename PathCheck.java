package hw9;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * A class used to determine if a path exists from the top of a grid to the bottom
 */
public class PathCheck {

	// IMPORTANT:
	// Use the uf field below to help you solve the problem.
	// Note, however, that this one field is not enough.
	// You will need to have additional fields, but you must use
	// the uf field in solving the probem.
	private WeightedQuickUnionUF uf;
	private int[] parent;  
    private int[] sites;    
    private int count; 
	/**
	 * Models an initial <code>size</code> by <code>size</code> grid with no cells selected.
	 * 
	 * @param size the length and width of the grid.
	 */
	public PathCheck(int size)  {
		count = size;
        parent = new int[size];
        sites = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sites[i] = 1;}}

	public int count() {
        return count;
    }
	
	public int find(int p) {
        validate(p);
        int root = p;
        while (root != parent[root])
            root = parent[root];
        while (p != root) {
            int newp = parent[p];
            parent[p] = root;
            p = newp;
        }
        return root;
    }
	private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));  
        }
    } 
	public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if (sites[rootP] < sites[rootQ]) {
            parent[rootP] = rootQ;
            sites[rootQ] += sites[rootP];
        }
        else {
            parent[rootQ] = rootP;
            sites[rootP] += sites[rootQ];
        }
        count--;
    }    
	/**
	 * Selects the cell in given <code>row</code> and <code>col</code> and returns
	 * <code>true<code> if there is a path of selected cells from the top of the grid
	 * to the bottom, and <code>false</code> otherwise.
	 * 
	 * @param row the row of the cell to be selected.
	 * @param col the column of the cell to be selected.
	 * @return <code>true<code> if there is a path of selected cells from the top of the grid
	 * to the bottom, and <code>false</code> otherwise.
	 * @throws IllegalArgumentException if either <code>row</code> or <code>col</code> is
	 * out of bounds (greater than or equal to size or negative).
	 * */
	public boolean select(int row, int col) {
		return find(col) != find(row);}

	public static void main(String args[]) 
{ 
		PathCheck pc = new PathCheck(2);

		boolean zeroZero = pc.select(0,0);
		
		 System.out.println(zeroZero);

		boolean oneOne = pc.select(1,1);
		
		 System.out.println(oneOne);

		boolean zeroOne = pc.select(0,1);
		
		 System.out.println(zeroOne);
}}