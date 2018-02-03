package sorting;

public class HelloSortingAlgo {

	public static void main(String[] args) {
		int[] input =  {3,6,1,35,74,24};
		
		System.out.println("Input:");
		for(int i: input){
			System.out.print(i + " ");
		}
		System.out.println();		
		System.out.println();		
		System.out.println("Sorted Result:");
		
		BubbleSort bs = new BubbleSort();
		int[] result = bs.bubbleSort(input);
		for(int i: result){
			System.out.print(i + " ");
		}
		

	}

}
