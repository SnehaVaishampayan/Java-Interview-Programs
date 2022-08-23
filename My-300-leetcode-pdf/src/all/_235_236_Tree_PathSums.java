package all;

import java.util.*;

import all._264_LargestBSTSubtree.TreeNode;

public class _235_236_Tree_PathSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    // *********************************************************************************************************
    // If path exists with pathSum == targetSum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Edge case
        if(root == null ) {
            return false;
        }
        targetSum = targetSum - root.val;
        if(root.left == null && root.right == null) {
            return targetSum == 0;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
    
    
    // *********************************************************************************************************
    // Get nodes with pathSum == targetSum
    public List<List<Integer>> pathSum_getPath(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null ) {
            return result;
        }
        recursive_pathSum_getPath(root, targetSum, new ArrayList<>(), result);
        return result;
    }
    private void recursive_pathSum_getPath(TreeNode root, int targetSum, List<Integer> subArray, List<List<Integer>> result) {
        // Edge case
        if(root == null) {            // here if add to result.. then gets added twice.. for left null and right null
            return;
        }
        if(root.left == null && root.right == null) { 	// here stops at root
            targetSum = targetSum - root.val;			// calc.. add.. remove            
            if(targetSum == 0) {	
                subArray.add(root.val);
                result.add(new ArrayList<>(subArray));
                subArray.remove(subArray.size() - 1);
            }
            return;
        }
        	
        subArray.add(root.val);					// calc.. add.. remove
        targetSum = targetSum - root.val;
        recursive_pathSum_getPath(root.left, targetSum, subArray, result);
        recursive_pathSum_getPath(root.right, targetSum, subArray, result);
        subArray.remove(subArray.size() - 1);
    }

    // *********************************************************************************************************
    // Get count of paths where pathSum == targetSum
    
    int result = 0;
    int remainder;
    Map<Integer, Integer> hm = new HashMap<>(); // currSum / countOfPathsWithCurrSum
    
    public int pathSum_count(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;            
        }    
        this.remainder = targetSum;
        recursiveGetCount(root, 0);
        return result;
    }
    private void recursiveGetCount(TreeNode node, int currSum) {
        if(node == null) {
            return;
        }
        currSum = currSum + node.val;
        
        if(currSum == remainder) {
            result++;
        }
        if(hm.containsKey(currSum - remainder)){
            result = result + hm.get(currSum - remainder);
        }
        
        
        if(hm.containsKey(currSum)) {
            hm.put(currSum, hm.get(currSum) + 1);
        }
        
        else {
            hm.put(currSum, 1);
        }
        recursiveGetCount(node.left, currSum);
        recursiveGetCount(node.right, currSum);
        hm.put(currSum, hm.get(currSum) - 1);
    }
    
}
