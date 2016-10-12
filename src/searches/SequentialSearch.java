package searches;

public class SequentialSearch {

	private static int[] theArray;
	private static boolean comments;
	
	public SequentialSearch(int[] data, boolean _comments){
		theArray = data;
		comments = _comments;
	}
	
	// Sequential Search is extremely straight forward. Take a set of data, and
	// iterate through it to find the value you need. This search can also find
	// multiple elements in the data set of the same value, unlike binary search.
	public void sequentialSearch(int value){
		boolean found = false;
		if(comments)
			System.out.println("Begin Sequential Search for value " + value);
		
		for(int i = 0; i < theArray.length; i++){
			if(theArray[i] == value){
				found = true;
				System.out.println("Value of " + value + " found in index " + i + ".");
				//continue;
			}
			
			// This section only works if the data being given is SORTED
			// If it's unsorted, must traverse through all elements
			//
			//if(theArray[i] > value){
			//	if(!found && comments)
			//		System.out.println("Value of " + value + " not found in the array.");
			//	System.out.println("Value of " + theArray[i] + " in index " + i + " is larger than "
			//			+ "search term of " + value + ". Ending search.");
			//	break;
			//}
			if(comments)
				System.out.println("Value in index " + i + " is " + theArray[i] + ". Doesn't equal " + value + ".");
		}
	}
}
