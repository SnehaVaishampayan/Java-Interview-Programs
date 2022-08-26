package tree;

import java.util.*;

import tree._264_LargestBSTSubtree.TreeNode;

public class _248_247_Tree_LCA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public Node lowestCommonAncestor(Node p, Node q) {
        
        if(p == null && q == null) {
            return p;
        }
        
        if(p == null || q == null) {
            return p == null ? q : p;
        }
        
        if(p.val == q.val) {
            return p;
        }
        
        Set<Node> hs = new HashSet<>();
        
        while(p != null) {
            hs.add(p);
            p = p.parent;
        }
        while( q != null) {
            if(hs.contains(q)) {
                return q;
            }
            q = q.parent;
        }
        return null;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
    //	LCA - Binary Search Tree 
    public TreeNode lowestCommonAncestor_BST(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val) {
              return lowestCommonAncestor_BST(root.left, p, q);
          }
          else if (p.val > root.val && q.val > root.val) {
              return lowestCommonAncestor_BST(root.right, p, q);
          }
          else {
              return root;
          }
      }
    
    //	LCA - Binary Tree 
    public TreeNode lowestCommonAncestor_BT(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        
        if(root == p || root == q) {
            return root;
        }
        
        // traverse 
        
        TreeNode left = lowestCommonAncestor_BT(root.left, p, q);
        TreeNode right = lowestCommonAncestor_BT(root.right, p, q);
        
        if(left != null && right != null) {
            return root;
        }
        
        return (left != null) ? left: right;
    }
}
