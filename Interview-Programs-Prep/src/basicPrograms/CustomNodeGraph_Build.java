package basicPrograms;
import java.util.*;


//	[A] -- [B] -- [C]
// 	 |  
//	[D] -- [E]

//	Graph .. collection/ array of AdjacencyListsOfEdges
//	A-> [B][D] 
//	B-> [A][C]
//	C-> [B]
//	D-> [A][E]
//	E-> [D]


//class Graph<K, E> {}

//Graph .. collection/ array of AdjacencyListsOfEdges
//A-> [B][D] 
//B-> [A][C]
//C-> [B]
//D-> [A][E]
//E-> [D]

class Graph<K, E> {
	Map<K, List<Node<K, E>>> graph;
	public Graph() {
		this.graph = new HashMap<K, List<Node<K,E>>>();
	}
	
	public boolean addEdge(K sourceNode, K destNode, E edge) {
		if(graph.containsKey(sourceNode)) {
			List<Node<K, E>> nodeConnections = graph.get(sourceNode);
			nodeConnections.add(new Node<K, E>(sourceNode, destNode, edge));
		}
		else {
			List<Node<K, E>> newList = new LinkedList<Node<K,E>>();
			newList.add(new Node<K, E>(sourceNode, destNode, edge));
			graph.put(sourceNode, newList);
		}
		return true;
	}
	
	public String toString() {
		String res = "";
		for(Map.Entry<K, List<Node<K, E>>> eachEntry: graph.entrySet() ) {
			res += eachEntry.getKey() + ", " +  eachEntry.getValue() + "\n";
		}
		return res;
	}
}

class Node<K, E> {
	K sourceNode;
	K destNode;
	E edge;
	public Node(K sourceNode, K destNode, E edge) {
		this.sourceNode = sourceNode;
		this.destNode = destNode;
		this.edge = edge;
	}
	
	@Override
	public boolean equals(Object node) {
		return sourceNode.equals(node);
	}
	
	@Override
	public int hashCode() {
		return sourceNode.hashCode();
	}
	
	@Override
	public String toString() {
		return (sourceNode + " -> " + destNode );				
	}
}

public class CustomNodeGraph_Build {
	public static void main(String[] args) {

		Graph<Character, Integer> test_graph = new Graph<Character, Integer>();
		test_graph.addEdge('A', 'B', 1);
		test_graph.addEdge('A', 'D', 1);
		
		test_graph.addEdge('B', 'A', 1);
		test_graph.addEdge('B', 'C', 1);
		
		test_graph.addEdge('C', 'B', 1);
		
		test_graph.addEdge('D', 'A', 1);
		test_graph.addEdge('D', 'E', 1);
		
		test_graph.addEdge('E', 'D', 1);
		
		System.out.println(test_graph);
	}
}