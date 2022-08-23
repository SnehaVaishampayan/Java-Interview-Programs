package all;

import java.util.*;

import all._264_LargestBSTSubtree.TreeNode;

public class _229_224_Pre_In_Post_Level_RevLevel_Vertical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    // Map of Column - list of locations(row-val)
    // Traverse preorder dfs - (node, map, row, col)
    //         if col in map - add pointLocation(row and val)
    //          add entry
    // once traversed.. 
    //      get each list and sort pointLocations on row 
    
    class Location {
        int row;
        int data;
        public Location(int r, int data) {
            this.row = r;
            this.data = data;
        }
        
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {               
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;        
        
        // Map of Column - list of locations(row-val)
        Map<Integer, List<Location>> hm = new TreeMap<>(); // order by column
        
        preOrderTraversal(root, hm, 0, 0);
        
        for(Map.Entry<Integer, List<Location>> eachEntry: hm.entrySet()) {
            // Get List of location - mapValue
            // Sort list of location
            // iterate thru list and add data to result sublist 
            
            List<Location> mapValue = eachEntry.getValue();                       
            Collections.sort(mapValue, new Comparator<Location>() {		// Sort
                   @Override
                    public int compare(Location l1, Location l2) {
                        return l1.row - l2.row;
                    }
                });
            
            List<Integer> subList = new ArrayList<>();		// iterate and add to sublist
            for(Location eachLocation: mapValue) {
                subList.add(eachLocation.data);                
            }
            result.add(subList);							// Add to result
        }  
        return result;        
    }
    
    private void preOrderTraversal(TreeNode node, Map<Integer, List<Location>> hm, int row, int col) {
        
        if(node == null) {
            return;
        }

        if(hm.containsKey(col)) {
            List<Location> subList = hm.get(col);
            
            subList.add(new Location(row, node.val));
            hm.put(col, subList);
        }
        else {
            List<Location> subList = new ArrayList<>();
            subList.add(new Location(row, node.val));
            hm.put(col, subList);
        }
        
        preOrderTraversal(node.left, hm, row + 1, col - 1);
        preOrderTraversal(node.right, hm, row + 1 , col + 1);
    }
}
