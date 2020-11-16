package basicPrograms;

import java.util.*;

public class SimpleGraphTraversals_DFS_BFS {
	// ================================= Depth First Search ==========================================
	static void DFSUtil(int v, boolean visited[], Int_Graph g) {
		visited[v] = true; // Mark the current node as visited and print it 
		System.out.print(v+" "); 

		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> i = g.adj[v].listIterator(); 
		while (i.hasNext()) 
		{ 
			int n = i.next(); 
			if (!visited[n]) 
				DFSUtil(n, visited, g); 
		}
	} 

	// The function to do DFS traversal. It uses recursive DFSUtil() 
	static void DFS(int v, Int_Graph g) {
		boolean visited[] = new boolean[g.noOfVertices]; // Mark all the vertices as not visited(set as false by default in java)
		DFSUtil(v, visited, g); // Call the recursive helper function to print DFS traversal 
	}
	// ================================= Breadth First Search ==========================================
	
	static void BFS(int source, Int_Graph g) {
		boolean visited[] = new boolean[g.noOfVertices];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		visited[source] = true;
		queue.add(source);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			visited[node] = true;
			System.out.print(" " + node);
				
			Iterator<Integer> itr = g.adj[node].iterator();
			while(itr.hasNext()) {
				int n = itr.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}		
		}		
	}
	
	public static void main(String args[]) 
	{ 
		Int_Graph g = new Int_Graph(4); 

		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(2, 3); 
		g.addEdge(3, 3); 

		System.out.println("Following is Depth First Traversal "+ "(starting from vertex 2)"); 
		DFS(2, g); 
		System.out.println("Following is Breadth First Traversal "+ "(starting from vertex 2)"); 		
		BFS(2, g); 

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
