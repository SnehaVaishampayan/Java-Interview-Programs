package tree;

import java.util.*;

public class _250_251_Tree_PopulateNextRightPtrs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Node connect(Node node) {

		if(node == null) {
			return node;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.offer(node);

		while(!q.isEmpty()) {

			int currQsize = q.size();

			for(int  i = 0 ; i < currQsize; i++) { //iterate curr level nodes

				Node currNode = q.poll();

				if(i < currQsize-1) {
					currNode.next = q.peek(); // attache to next ele
				}

				if(currNode.left != null) {
					q.offer(currNode.left);
				}
				if(currNode.right != null) {
					q.offer(currNode.right);
				}
			}
		}
		return node;
	}

	public class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}
}