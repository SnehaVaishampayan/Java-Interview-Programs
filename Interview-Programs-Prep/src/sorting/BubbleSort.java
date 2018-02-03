package sorting;

public class BubbleSort {


	public int[] bubbleSort(int[] arr){

		boolean swapped  = false;
		
		for(int itr = 0; itr < arr.length-1; itr++){
			swapped = false;
			for(int i = 0; i < arr.length - itr - 1; i++){ // Every itr greater element will bubble out at end. 
				if(arr[i] > arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					swapped = true;
				}
			}
			// If no two elements swapped by inner for j, then break.. means all in order.. 
			if(swapped == false){
				break;
			}
		}
		return arr;
	}
}
