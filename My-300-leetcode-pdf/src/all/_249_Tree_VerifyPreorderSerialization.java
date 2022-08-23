package all;

public class _249_Tree_VerifyPreorderSerialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isValidSerialization(String preorder) {

		int nullNodesCount = 1;

		for(String s: preorder.split(",")) {
			// reduce slot for each empty node
			nullNodesCount--;
			if(nullNodesCount < 0) {
				return false;
			}
			// increase slots for each empty node
			if(!s.equals("#")) {
				nullNodesCount+=2;
			}

		}
		return nullNodesCount == 0;
	}
}
