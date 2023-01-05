package basicPrograms;

import java.util.*;

public class SimpleGraphTraversals_DFS_BFS {
	// ================================= Depth First Search ==========================================

	// The function to do DFS traversal. It uses recursive DFSUtil() 
	static void DFS(int v, Int_Graph g) {
		boolean recursive_visited[] = new boolean[g.noOfVertices]; // Mark all the vertices as not visited(set as false by default in java)
		dfs_recursive(v, recursive_visited, g); // Call the recursive helper function to print DFS traversal 
		System.out.println();
		System.out.println("** non recursive ");
		boolean non_recursive_visited[] = new boolean[g.noOfVertices]; 
		dfs_NON_recursive(v,non_recursive_visited, g);
		System.out.println("** non recursive ");
	}

	static void dfs_recursive(int v, boolean visited[], Int_Graph g) {
		visited[v] = true; // Mark the current node as visited and print it 
		System.out.print(v+" "); 

		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> i = g.adj[v].listIterator(); 
		while (i.hasNext()) 
		{ 
			int n = i.next(); 
			if (!visited[n]) 
				dfs_recursive(n, visited, g); 
		}
	} 
	static void dfs_NON_recursive(int start, boolean visited[], Int_Graph g) {
		// create stack. 
		// Put start in stack
		// while stack not empty.. 
		//	get node from stack
		//	if not visited.. 
		//		make visited.. process .. put adjacent neighbors in stack 
		Stack<Integer> dfs_stack = new Stack<>();
		dfs_stack.push(start);

		while(!dfs_stack.isEmpty()) {
			int curr_node = dfs_stack.pop();

			if(!visited[curr_node]) {
				visited[curr_node] = true; // make visited. 
				System.out.print(" "+ curr_node); // process 

				for (Integer neighbor : g.adj[curr_node]) {
					if(!visited[neighbor])
						dfs_stack.push(neighbor);
				}
			}
		}
	}


	// ================================= Breadth First Search ==========================================

	static void BFS(int source, Int_Graph g) {
		boolean visited[] = new boolean[g.noOfVertices];
		Queue<Integer> bfs_queue = new LinkedList<Integer>();

		//		visited[source] = true;
		bfs_queue.add(source);

		while(!bfs_queue.isEmpty()) {

			int curr_node = bfs_queue.poll();


			if(!visited[curr_node]) {
				visited[curr_node] = true;			// make visited.
				System.out.print(" " + curr_node);	// process 

				for (Integer neighbor : g.adj[curr_node]) {
					if(!visited[neighbor])
						bfs_queue.add(neighbor);
				}
			}

		}		
	}

	public static void main(String args[]) 
	{ 
		Int_Graph g = new Int_Graph(4); 

		g.addEdge(2, 0); 
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(0, 1);
		g.addEdge(3, 3);
		g.addEdge(1, 3);

		System.out.println("Following is Depth First Traversal "+ "(starting from vertex 2)"); 
		DFS(2, g);
		System.out.println();
		System.out.println("Following is Breadth First Traversal "+ "(starting from vertex 2)"); 		
		BFS(0, g); 

	} 
}

// This class represents a directed graph using adjacency list representation 
class Int_Graph {
	public int noOfVertices;   // No. of vertices 
	public LinkedList<Integer> adj[]; // Array  of lists for Adjacency List Representation 

	public Int_Graph(int v) 
	{ 
		noOfVertices = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i < v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	void addEdge(int v, int w) { //Function to add an edge into the graph  
		adj[v].add(w);  // Add w to v's list. 
	}
}