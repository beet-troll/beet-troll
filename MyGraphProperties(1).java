// Exercise 4.1.16
package algs41;
import algs13.Queue;
import algs41.Graph;
import algs41.GraphGenerator;
import stdlib.*;

// This is problem 4.1.16 from the textbook
//
// You need only change the constructor.
// You can also change the main method.
// But you should not change eccentricity(), diameter(), radius(), center() or isCenter()
// You can (and should!) add more private methods (such as bfs or dfs)
//
// TODO: complete the following, using only Graph and GraphGenerator. 
// You may copy code from other classes in algs41, but you should not use the classes themselves.  
// In particular, you may not use BreadthFirstPaths although you may copy code from there.
//
// Definitions:
//   - The "distance" from vertex v to vertex w is the length of the shortest path from v to w.
//   - The "eccentricity" of a vertex v is distance to the farthest vertex from v.
//   - The "diameter" of a graph is the maximum eccentricity of any vertex. 
//   - The "radius" of a graph is the smallest eccentricity of any vertex. 
//   -  A "center" is a vertex whose eccentricity is the radius. The center is not necessarily unique.

public class MyGraphProperties {
	private static final int INF = Integer.MAX_VALUE;
	int[] eccentricity;
	int diameter = 0;
	int radius = INF;
	int center = INF;
	int count = 0;
	private boolean[] mark;  
	private int[] edgeTo;     
	private int[] distTo;      
	
	// Constructor can be linear in G.V() * G.E()
	public MyGraphProperties(Graph G) {
	// If G.V()==0, then these are the correct values.
	// If G is not connected, you should throw a new IllegalArgumentException()
	// I suggest that you first get it to work for a connected graph
	// This will require that you traverse the graph starting from some node (say 0)
	// You can then adjust your code so that it throws an exception in the case that all nodes are not visited
	//}
	// compute the eccentricity, diameter, radius and center
	// The center of the graph is not unique, set center to SOME center --- it does not matter which one
	this.eccentricity = new int[G.V()];
	marked = new boolean[G.V()];
	distTo = new int[G.V()];
	edgeTo = new int[G.V()];
	getProperties(G);
	}
	private void BFS(Graph G, int x) {
		Queue<Integer> queue = new Queue<>();
		for (int i = 0; i < G.V(); i++) 
		{
			distTo[i] = INF; 
			marked[i] = false;
		} 
		distTo[x] = 0;
		marked[x] = true;
		queue.enqueue(x);
		while (!queue.isEmpty()) {
			int i = queue.dequeue();
			for (int j : G.adj(i)) {
				if (!marked[j]) {
					edgeTo[j] = i;
					distTo[j] = distTo[i] + 1;
					marked[j] = true;
					queue.enqueue(j);}}}                
		count++;}

	private void getProperties(Graph G) {
		for(int vertex = 0; vertex < G.V(); vertex++) {
			BFS(G, vertex);
            	for(int altVertex = 0; otherVertex < G.V(); altVertex++) {
                	if (altVertex == vertex) {
                   		 continue;
                }
                
                eccentricity[vertex] = Math.max(eccentricity[vertex], distTo[altVertex]);
            	}
            	if (eccentricity[vertex] > diameter) {
                	diameter = eccentricity[vertex];
            	}
            	if (eccentricity[vertex] < radius) {
             		radius = eccentricity[vertex];
                	center = vertex;
            	}
            	if (eccentricity[vertex] == INF) {
              		throw new RuntimeException("Graph is not connected");}}}

	// Do not change the following constant time methods
	public int eccentricity(int v) { return eccentricity[v]; }
	public int diameter()          { return diameter; }
	public int radius()            { return radius; }
	public int center()            { return center; }
	public boolean isCenter(int v) { return eccentricity[v] == radius; }

	public static void main(String[] args) {
		//Graph G = GraphGenerator.fromIn (new In("data/tinyG.txt")); // this is non-connected -- should throw an exception
		//Graph G = GraphGenerator.connected (10, 20, 2); // Random non-connected graph -- should throw an exception

		Graph G = GraphGenerator.fromIn (new In("data/tinyCG.txt")); // diameter=2, radius=2, every node is a center
		//Graph G = GraphGenerator.binaryTree (10); // A complete binary tree
		//Graph G = GraphGenerator.path (10); // A path -- diameter=V-1
		//Graph G = GraphGenerator.connected (20, 400); // Random connected graph

		StdOut.println(G);
		G.toGraphviz ("g.png");

		MyGraphProperties gp = new MyGraphProperties(G);
		for (int v = 0; v < G.V(); v++)
			StdOut.format ("eccentricity of %d: %d\n", v, gp.eccentricity (v));
		StdOut.format ("diameter=%d, radius=%d, center=%d\n", gp.diameter(), gp.radius (), gp.center ());
	}
}