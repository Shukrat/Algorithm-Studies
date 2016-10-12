package searches;

public class BinarySearch {
	
	private static int[] theArray;
	private static boolean comments;
	
	public BinarySearch(int[] data, boolean _comments){
		theArray = data;
		comments = _comments;
	}
	
	public void binarySearchForValue(int value){
		int lowIndex = 0;
		int highIndex = theArray.length - 1;
		boolean found = false;
		
		if(comments)
			System.out.println("Begin Binary Search, looking for value " + value + ".");
		
		while(lowIndex <= highIndex){
			// Find closest middle point
			int middleIndex = (highIndex + lowIndex) / 2;
			
			if(comments)
				System.out.println("High index: " + highIndex + ". Low Index: " + lowIndex + ". Middle Index: " + middleIndex);
			
			// If the value in the array at the middle point is less than the value we're looking for
			// Then drop everything from position and lower
			// Make the new low the middle index + 1 to exclude the value looked at
			if(theArray[middleIndex] < value){
				if(comments)
					System.out.println("Value of " + theArray[middleIndex] + " is less than value desired of " + value +
							". Set Low Index to Middle Index + 1(" + (middleIndex + 1) + ").\n");
				lowIndex = middleIndex + 1;
			}
			
			// If the value in the array at the middle point is greater than the value we're looking for
			// Then drop everything from the position and higher
			// Make the new high the middle index + 1 to exclude the value looked at
			else if(theArray[middleIndex] > value){
				if(comments)
					System.out.println("Value of " + theArray[middleIndex] + " is greater than value desired of " + value +
							". Set High Index to Middle Index - 1 (" + (middleIndex - 1) + ").\n");
				highIndex = middleIndex - 1;
			}
			
			// If neither of the above are true, we've found our value
			else{
				System.out.println("Value of " + theArray[middleIndex] + " found!");
				System.out.println("Found a Match for " + value + " at Index " + middleIndex);
				
				found = true; // Set boolean to not found to let user know value doesn't exist.
				lowIndex = highIndex + 1; // Make the while loop's boolean evaluation false to break out
			}
		}
		if(!found){
			System.out.println("Low Index is equal to or greater than High Index. Ending search.");
			System.out.println(value + " not found in the array");
		}
	}
	
}
