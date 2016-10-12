package sorts;

import java.util.Arrays;

public class InsertionSort {
	
	private static int[] theArray;
	private static boolean comments;
	
	public InsertionSort(int[] data, boolean _comments){
		theArray = new int[data.length];
		for(int i = 0; i < data.length; i++){
			theArray[i] = data[i];
		}
		comments = _comments;
	}
	
	public int[] getArray(){
		return theArray;
	}
	
	public void insertionSort(){
		if(comments)
			System.out.println("\nInsertion Sort Beginning:");
		
		// Insertion Sort looks through the array from index 0 through its length-1
		for(int i = 0; i < theArray.length; i++){
			
			// Pull the value out of the array at the current iteration, i
			int currentValue = theArray[i];
			
			// Set position to current iteration, i
			int index = i;
			
			if(comments)
				System.out.println("Value in index " + i + " is " + currentValue + ".");
			
			// Loop through the array, starting from position and working backward. This essentially
			// integrates the next value in the array into a section that's currently sorted.
			// So while the index is bigger than 0, and the value to the left of the current index
			// is greater than the value in the current index, swap them. Then reduce index by one.
			while(index > 0 && theArray[index-1] > currentValue){
				if(comments && index > 0){
					System.out.println("Value in index " + (index - 1) + " is " + theArray[index-1] + 
							". It is greater than " + currentValue + ". Switching " + theArray[index-1] + 
							" and " + currentValue + ".");
					
					System.out.println(Arrays.toString(theArray));
				}
				
				// Swap the values. Note this just copies the value directly to the current index
				// It doesn't place the currentValue in, as it still needs to check the next index to 
				// the left
				theArray[index] = theArray[index-1];				
				index--;
			}
			
			// Finally, replace the current index with the currentValue
			theArray[index] = currentValue;
			if(comments)
				System.out.println("Placing " + currentValue + " into array at index " + 
						index + ". Values to the left of index " + i + " are now sorted." + 
						"\n" + Arrays.toString(theArray) + "\n");
		}
	}
	
}
