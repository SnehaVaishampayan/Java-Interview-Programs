package tree;

public class _264_LargestBSTSubtree {
	// track minLimit, maxLimit, currTreeSize;

	/// traverse left.. right.. process -- PostOrder
	// process..    if satisfies BST node property.. 
	//                  update min= max(node.val, leftNodeMin) max= min(node.val, rightNodeMax) limits 
	//                  currSize = max(leftNodeSize + rightNodeSize + 1, resMaxSize)

	//              else update size = 0; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class TreeNode { 
		int val; 
		TreeNode left; 
		TreeNode right; 
		TreeNode() {} 
		public TreeNode(int val) { 
			this.val = val; 
		}
		public TreeNode(int val, TreeNode left, TreeNode right) { 
			this.val = val; 
			this.left = left; this.right = right;
		}
	}

    // track minLimit, maxLimit, currTreeSize;
    
    /// traverse left.. right.. process -- PostOrder
    // process..    if satisfies BST node property.. 
    //                  update min= max(node.val, leftNodeMin) max= min(node.val, rightNodeMax) limits 
    //                  currSize = max(leftNodeSize + rightNodeSize + 1, resMaxSize)
    
    //              else update size = 0; 
    

    int res;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        postOrderTraverse(root);        
        return res;
    }
    
    public NodeInfo postOrderTraverse(TreeNode node) {
        
        NodeInfo currNodeInfo = new NodeInfo(node.val, node.val, 0); // currNode_minLimit , currrNode_maxLimit, currSubtree_Size
                
        NodeInfo leftNodeInfo = node.left == null? currNodeInfo : postOrderTraverse(node.left);
        NodeInfo rightNodeInfo = node.right == null ? currNodeInfo : postOrderTraverse(node.right);
        
        
        if(leftNodeInfo.currSubtreeSize == -1 || rightNodeInfo.currSubtreeSize == -1 ) {
            currNodeInfo.currSubtreeSize = -1;
            return currNodeInfo;
        }
        
        if((node.left == null || node.val > leftNodeInfo.maxLimit) && (node.right == null || node.val < rightNodeInfo.minLimit)) {
            currNodeInfo.currSubtreeSize = leftNodeInfo.currSubtreeSize + rightNodeInfo.currSubtreeSize + 1; 
            res = Math.max(res, currNodeInfo.currSubtreeSize);
            currNodeInfo.minLimit = Math.min(node.val, leftNodeInfo.minLimit);
            currNodeInfo.maxLimit = Math.max(node.val, rightNodeInfo.maxLimit);                       
        }
        else {
            currNodeInfo.currSubtreeSize = -1; // Not BST
        }
        return currNodeInfo;
    }    
    
    class NodeInfo {
        int minLimit;
        int maxLimit;
        boolean isSubtreeBST;
        int currSubtreeSize;
        
        public NodeInfo(int a, int b, int c){
            this.minLimit = a;
            this.maxLimit = b;
            this.isSubtreeBST = false;
            this.currSubtreeSize = 0;
        }
    }
}
