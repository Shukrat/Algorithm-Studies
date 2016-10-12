package sorts;

import java.util.Arrays;

public class SelectionSort {

	private static int[] theArray;
	private static boolean comments;
	
	public SelectionSort(int[] data, boolean _comments){
		theArray = new int[data.length];
		for(int i = 0; i < data.length; i++){
			theArray[i] = data[i];
		}
		comments = _comments;
	}
	
	public void selectionSort(){
		if(comments)
			System.out.println("Beginning Selection Sort:");
		// Loop through from 0 to the max location in array
		for(int i = 0; i < theArray.length; i++){
			
			// Assume minimum is value is in index i at start to carry into next loop
			int minimum = i;
			
			if(comments)
				System.out.println("\nMinimum index is " + minimum);
			
			// Loop again, but start from i + 1
			for(int j = i + 1; j < theArray.length; j++){
				
				// If the value in the index of minimum is bigger than the value in the index of j
				// Set minimum to current value of j
				if(theArray[minimum] > theArray[j]){
					if(comments)
						System.out.println("Value in index " + minimum + " is " + 
								theArray[minimum] + ". It is greater than the value in index " +
								j + " of " + theArray[j] + "." + " Setting current minimum index to " + j + ".");
					
					// Set minimum to j, continue loop checking value against the rest of the array
					minimum = j;
				}
				else{ // Exists for the purpose of putting info to the console
					if(comments)
						System.out.println("Value in index " + j + " is smaller than value in index " + minimum
								+ ". Moving to next index.");
				}
			}
			if(comments)
				System.out.println("Value in index " + minimum + " is smallest found.");
			
			// Swap the values in these two locations once the loop for j is complete
			// This means that the value at index minimum is the smallest found in the remaining
			// section of array to sort through
			if(minimum != i)
				swapValues(i, minimum);
			if(comments)
				System.out.println(Arrays.toString(theArray));
		}
	}
	
	public void swapValues(int indexOne, int indexTwo){
		if(comments)
			System.out.println("Swapping value " + theArray[indexOne] + " in index " + indexOne + 
					", with value " + theArray[indexTwo] + " in index " + indexTwo + ".");
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;
	}
	
	public int[] getArray(){
		return theArray;
	}
	
}
