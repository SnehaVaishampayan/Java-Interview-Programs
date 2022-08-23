package all;

import java.util.*;

import all._264_LargestBSTSubtree.TreeNode;

public class _256_Tree_ClosestValueBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        
        int closestValue;
        
        double min = Double.MAX_VALUE;
        
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> Math.abs(o1 - target) > Math.abs(o2 - target) ? -1 : 1);
        helper(root, target, heap,k);
        return new ArrayList<>(heap);
    }
    public void helper(TreeNode root, double target, Queue<Integer> heap, int k){
        if(root==null)
            return;
        // ************** ASKED FOR SINGLE CLOSEST VALUE ********************
        // if(Math.abs(root.val - target) < min) {
        //     min = Math.abs(root.val - target);
        //     closestValue = root.val;
        // }
        
//        ************** ASKED FOR LIST OF CLOSEST VALUES ********************
        heap.add(root.val);
        
        if (heap.size() > k) 
            heap.remove();
        
        if(target < root.val) {
            helper(root.left, target, heap,k);
        }
        
        else {
            helper(root.right, target, heap,k);
        }
    }
}
