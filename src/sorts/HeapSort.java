package sorts;

import java.util.Arrays;

public class HeapSort {
	
	private int[] theArray;
	private static boolean comments;
	
	public HeapSort(int[] data, boolean _comments){
		theArray = new int[data.length];
		for(int i = 0; i < data.length; i++){
			theArray[i] = data[i];
		}
		comments = _comments;
	}
	
	public int[] getArray(){
		return theArray;
	}
	
	public void heapSort(){
		if(comments)
			System.out.println("\nBegin Heap Sort:");
		
		int length = theArray.length;
		if(comments)
			System.out.println("Within this data set, there will only be " + ((length / 2)) + " nodes with children." +
					"\nSo our loop will run from the bottom of the tree up, starting with parent node in index " + ((length / 2)-1) + ".");
		 
        // Build heap (rearrange array)
        for (int i = length / 2 - 1; i >= 0; i--){
        	if(comments)
        		System.out.println("\nHeap our data set. Pass in length of array: " + length + ". Start at parent node, i, in index: " + i + ".");
        	
        	// Pass in our data set, the length to check (which is the whole thing, for this portion), starting at i.
        	// i, will always be (length / 2) - 1, and represents the number of parent nodes in a binary tree.
        	// Through each loop, the value of i is decremented, to move backward (or up) the tree to each successive parent node.
        	heapArray(theArray, length, i);
        }
        
        if(comments){
        	System.out.println("\nCurrent data set layout:\n" + 
        			Arrays.toString(theArray) + 
        			"\nHEAP CONSTRUCTED. MAX VALUE IN ARRAY IS IN INDEX 0.");
        	System.out.println("\nThis next pass through the heap moves the currently largest node, at index " +
        			"0, \nto the other end of the array, then runs the same algorithm to move the next largest value " +
        			"\nto index 0 of the array.");
        }
        
        // One by one extract an element from heap
        for (int i = length - 1; i >= 0; i--)
        {
            // Move current root to end. Current root has the largest value in the array.
        	// Moving it to the end puts it outside of the length we're checking in the array.
        	// Since i above is the length - 1, and decremented by 1 each loop, anything in the max
        	// 		index location(s) will not be looked at in the sort.
        	if(comments)
        		System.out.println("\nMove current root at index 0, to index of " + i + ".");
            int temp = theArray[0];
            theArray[0] = theArray[i];
            theArray[i] = temp;
            
            if(comments)
            	System.out.println("Heap our data set. Pass in length of array to check: " + i + ". Start at parent node in index: " + 0 + ".");
            
            // Pass in the data set, the length (from 0 to i's value) to check in the array, starting at the root (index 0)
            heapArray(theArray, i, 0);
        }
    }
	
	void heapArray(int data[], int length, int i)
    {
		// i, in this case, is the root/parent node of this subtree
        int largestChild = i;  // Assume root passed in, i, is the largest value out of the 3 being checked.
        
        // Each child node from a parent node will always be twice its index location, plus 1 (or 2, for right child).
        int leftChild = 2*i + 1;  // left = 2*i + 1 -> Due to binary tree structure.
        int rightChild = 2*i + 2;  // right = 2*i + 2 -> Due to binary tree structure.
        
        if(comments){
        	System.out.println("largestChild index: " + largestChild + ". leftChild index: " + leftChild + ". rightChild index: " + rightChild + ".");
        	System.out.println("Initial data set state:\n" + Arrays.toString(data));
        }
 
        // If leftChild index is within the length of the array
        // And if value at index leftChild is bigger than value at largestChild
        if (leftChild < length && data[leftChild] > data[largestChild]){
        	if(comments)
            	System.out.println(data[leftChild] + " > " + data[largestChild] + ". leftChild value of " + data[leftChild] + " is greater than largestChild value of " + 
            			data[largestChild] + ".\nSet Largest Child to Left Child.");
        	
        	// Set largestChild to the leftChild instead. These are currently just index values
        	// The values at these indices will be swapped later, if need be.
        	largestChild = leftChild;
        }
 
        // If rightChild index is within the length of the array
        // And if value at index rightChild is bigger than value at largestChild
        if (rightChild < length && data[rightChild] > data[largestChild]){
        	if(comments)
        		System.out.println(data[rightChild] + " > " + data[largestChild] + ". rightChild value of " + data[rightChild] + " is greater than largestChild value of " + 
            			data[largestChild] + ".\nSet Largest Child to Right Child.");
        	
        	// Set largestChild to the rightChild instead. These are currently just index values
        	// The values at these indices will be swapped later, if need be.
        	largestChild = rightChild;
        }
            
 
        // If the largestChild index is not the original value it was set as
        // Swap the values at indices i (root/parent), and largestChild
        // If largestChild and i are equivalent, that means the largest value in this
        // sub-tree is already in the right location, and no change is necessary
        if (largestChild != i)
        {
            int temp = data[i];
            data[i] = data[largestChild];
            data[largestChild] = temp;
            if(comments)
            	System.out.println(Arrays.toString(data));
 
            // Do recursion using heapArray (this method) to check the affect sub-tree
            // This ensures that the subtree has has the largest value in its root/parent index
            heapArray(data, length, largestChild);
        }
        else{ // This only exists to put information out to the console, unnecessary otherwise
        	if(comments)
        		System.out.println("largestChild contains largest value, no more change necessary. Final data set state:\n" +
        				Arrays.toString(data));
        }
    }	
}
