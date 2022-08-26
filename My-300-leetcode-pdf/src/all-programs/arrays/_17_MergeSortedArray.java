package arrays;

public class _17_MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums1.length == 0) {
            return ;
        }
        
        if(nums2 == null || nums2.length == 0) {
            return ;
        }
        
        int r = m + n - 1;
        int i1 = m-1; int i2 = n-1;
        
        while(i1 >= 0 && i2 >= 0) {
            System.out.println("i1 " + i1 + ",i2 " + i2);
            if(nums2[i2] > nums1[i1] ) {
                nums1[r] = nums2[i2];
                i2--;
            }
            else {
                nums1[r] = nums1[i1];
                i1--;
            }
            r--;
        }
        System.out.println("r " + r + ",i2 " + i2);

        while(i2 >=0 ) {
            nums1[r] = nums2[i2];
            i2--;
            r--;
        }
    }
}
