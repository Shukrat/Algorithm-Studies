package sorts;

import java.util.Arrays;

public class QuickSort {

	private static int[] theArray;
	private static boolean comments;
	
	// Pass in the random array from the DataGenerator class
	public QuickSort(int[] data, boolean _comments){
		theArray = new int[data.length];
		for(int i = 0; i < data.length; i++){
			theArray[i] = data[i];
		}
		comments = _comments;
	}
	
	public int[] getArray(){
		return theArray;
	}
	
	public void quickSort(int left, int right){
		if (right - left <= 0) return; // If the two array locations passed in are zero or less, there's nothing to sort. End.
		else{
			// Set the pivot to the right most index value
			// Sometimes this pivot point will be a random index between the left and right index
			// Doing a random index for the pivot has the effect of bringing the average run time for this sort
			// 		closer to O(n log(n)) rather than the worst case of O(n^2)
			int pivot = theArray[right]; 
			
			if(comments){
				System.out.println("Value in index " + right + " of " + theArray[right] +
						" is made pivot value for partition.");
				
				System.out.println("Left index = " + left + ". Right index = " + right
						+ ". Pivot value = " + pivot + ". Sent to be partitioned");
			}	
			// Get the pivot value's ending index (since it gets shuffled around)
			// This index is used to define the left and right sections of the array to be sorted 
			int pivotIndex = partitionArray(left, right, pivot);

			// Sort the values less than the previous pivot value (-1 because the value in pivotIndex is in the correct location)
			// Uses the above pivotIndex to sort the left side recursively
			quickSort(left, pivotIndex - 1);
			
			// Sort the values greater than the previous pivot value (+1 because the value in pivotIndex is in the correct location)
			// Uses the above pivotIndex to sort the right side recursively.
			quickSort(pivotIndex + 1, right);
		}
	}
	
	
	public int partitionArray(int left, int right, int pivot){
		int leftPointer = left - 1; // Subtract 1 because the while loop below increases the value by 1 first.
		int rightPointer = right; 
		
		while(true){
			// While the value in the array at the leftPointer is less than the pivot, loop
			// Loop increases the value of leftPointer by 1 each time.
			// Loop ends when the value is greater than than the pivot
			while(theArray[++leftPointer] < pivot)
				;
			
			if(comments)
				System.out.println("\nValue in index " + leftPointer + " is " + theArray[leftPointer] +
						". This is equal to or bigger than the pivot value of " + pivot + ".");

			// While the value in the array at the rightPointer is greater than the pivot, loop
			// Loop decreases the value of rightPointer by 1 each time
			// Loop ends when the value is less than the pointer
			// NOTE: Needs the extra "while greater than 0" because there's a possibility of going below 0
			// 		 and getting a null pointer reference error
			while(rightPointer > 0 && theArray[--rightPointer] > pivot)
				;
			
			if(comments)
				System.out.println("Value in index " + rightPointer + " is " + theArray[rightPointer] +
						". This is equal to or smaller than the pivot value of " + pivot + ".");
			
			// If the leftPointer index is to the right of the rightPointer index, just end instead of swapping
			if(leftPointer >= rightPointer){
				if(comments)
					System.out.println("Left index of " + leftPointer + " is greater than right index of " + rightPointer + ". Finish by swapping value " +
							theArray[leftPointer] + " in index " + leftPointer + " with original pivot of value " +
							theArray[right] + " in index " + right + ".");
				break;
			}
			else{ // Otherwise, swap the two values in the pointer locations
				swapValues(leftPointer, rightPointer);
				if(comments)
					System.out.println(Arrays.toString(theArray));
			}
		}
		
		// This final swap moves the pivot value to its correct and final index 
		swapValues(leftPointer, right);
		
		if(comments)
			System.out.println(Arrays.toString(theArray) + "\n");
		
		// Return current value of leftPointer to use as the index point between the values greater than
		// and the values less than the previous pivot.
		return leftPointer;
	}
	
	public void swapValues(int indexOne, int indexTwo){
		if(comments)
			System.out.println("Swap value " + theArray[indexOne] + " in index " + indexOne + 
					" with value " + theArray[indexTwo] + " in index " + indexTwo + ".");
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;
	}
	
}
