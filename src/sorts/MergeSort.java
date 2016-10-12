package sorts;

import java.util.Arrays;

public class MergeSort {
	
	private static int[] theArray;
	private static boolean comments;
	
	public MergeSort(int[] data, boolean _comments){
		theArray = new int[data.length];
		theArray = new int[data.length];
		for(int i = 0; i < data.length; i++){
			theArray[i] = data[i];
		}
		comments = _comments;
		mergeSort(theArray);
	}
	
	private int[] mergeSort(int[] list){
		if(comments)
			System.out.println("\nBeginning Merge Sort on passed in data set of: \n"
					+ Arrays.toString(list));
		if(list.length <= 1){ // An array with a length of 1 is "sorted"
			if(comments)
				System.out.println("List is length of 1, and is considered sorted.");
			return list;
		}
		
		// Create 2 new lists that are half the size of the original
		if(comments)
			System.out.println("Split data into two halves:");
		int[] leftHalf = new int[list.length / 2];
		int[] rightHalf = new int[list.length - leftHalf.length];
		
		// Copy half the original list into the new "leftHalf" list
		// From position 0 to the length of the new "leftHalf" list
		System.arraycopy(list, 0, leftHalf, 0, leftHalf.length);
		if(comments)
			System.out.println("Left Half: \n" + Arrays.toString(leftHalf));
		
		// Copy half the original list into the new "rightHalf" list
		// Starting position in the original list is the length of the new "leftHalf" list
		System.arraycopy(list, leftHalf.length, rightHalf, 0, rightHalf.length);
		if(comments)
			System.out.println("Right Half: \n" + Arrays.toString(rightHalf));
		
		// Recursion: Do the above on the two new half-lists
		// This ends when the list passed in is a length of 1
		if(comments)
			System.out.println("RECURSION: Pass Left Half and Right Half arrays from " +
					"previous iteration of mergeSort method.");
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		
		// Now merge the leftHalf and rightHalf lists
		// Reminder: This is at the bottom of recursion when it first starts
		// So the lists will be a length of 1 to start, then 2, then 4, etc...
		// List will always be the combined length of the leftHalf and rightHalf arrays
		if(comments)
			System.out.println("\nMerge LeftHalf and RightHalf lists: \n" + 
					"Left Half: " + Arrays.toString(leftHalf) + " | Right Half: " + Arrays.toString(rightHalf));
		merge(leftHalf, rightHalf, list); // No return here since data is passed by reference
		
		return list;
	}
	
	private void merge(int[] leftHalf, int[] rightHalf, int[]list){
		// Set starting locations to the beginning position in any array
		int iLeftHalf = 0;
		int iRightHalf = 0;
		int iMerged = 0;
		
		// Loop: Both pointers need to be less than the length of the
		// lists they're referring to, otherwise you will get null reference errors
		while(iLeftHalf < leftHalf.length && iRightHalf < rightHalf.length){
			
			// If the value in the leftHalf array at position iLeftHalf
			// is less than the value in the second array at position iRightHalf
			if(Integer.compare(leftHalf[iLeftHalf], rightHalf[iRightHalf]) < 0){
				// Set the value at iMerged in list to the value in
				// the leftHalf array at position iLeftHalf
				list[iMerged] = leftHalf[iLeftHalf];
				
				if(comments){
					System.out.println("Left Half index of " + iLeftHalf + " with value " + leftHalf[iLeftHalf] +
							" is smaller than the Right Half index of " + iRightHalf + " with a value of " + 
							rightHalf[iRightHalf] + ".");
					System.out.println(leftHalf[iLeftHalf] + " inserted into list at index " + iMerged);
				}
				
				iLeftHalf++; // Move to the next value in the leftHalf array
			}
			else{
				// Set the value at position iMerged in list to the value in
				// the rightHalf array at position iRightHalf
				list[iMerged] = rightHalf[iRightHalf];
				
				if(comments){
					System.out.println("Right Half index of " + iRightHalf + " with value " + rightHalf[iRightHalf] +
							" is smaller than the Left Half index of " + iLeftHalf + " with a value of " + 
							leftHalf[iLeftHalf] + ".");
					System.out.println(rightHalf[iRightHalf] + " inserted into list at index " + iMerged);
				}
				
				iRightHalf++; // Move to the next value in the second array
			}
			iMerged++; // Move to the next position in list
		}
		
		// After the above while loop, there will be remaining values that are all sorted 
		// in the left or right half arrays, so merge the remaining values 
		// to the end of the list array
		// This can happen when you get through the whole list on the left or right
		// with multiple values remaining in the other.
		if(comments)
			System.out.println("Merging remaining value(s)");
		System.arraycopy(leftHalf, iLeftHalf, list, iMerged, leftHalf.length - iLeftHalf);
		System.arraycopy(rightHalf, iRightHalf, list, iMerged, rightHalf.length - iRightHalf);
		
		if(comments)
			System.out.println("Final merged list for this instance of recursion: " +
					"\n" + Arrays.toString(list) + "\n");
	}
	
	public int[] getArray(){
		return theArray;
	}
}
