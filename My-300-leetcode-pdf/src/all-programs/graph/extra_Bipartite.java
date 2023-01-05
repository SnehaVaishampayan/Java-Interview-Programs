package graph;

public class extra_Bipartite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public boolean twoColorable(int[][] edges) {
		// 0 - nocolor 1 - blue -1  - red
		int[] nodeColors = new int[edges.length];
		for(int i =0 ; i < nodeColors.length; i++) {
			if(nodeColors[i] == 0 && !isValidColor(edges, nodeColors,  i, 1)) {
				return false;
			}
		}
		return true;
	}

	private boolean isValidColor(int[][] edges, int[] nodeColors, int currNode, int currColor) {
		if(nodeColors[currNode] != 0) {
			return nodeColors[currNode] == currColor;
		}

		nodeColors[currNode] = currColor;

		for(int eachNeighbor: edges[currNode]) {
			if(!isValidColor(edges, nodeColors,  eachNeighbor, -currColor)){
				return false;
			}
		}
		return true;
	}


}
