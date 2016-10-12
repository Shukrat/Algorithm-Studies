import java.util.Arrays;

import searches.BinarySearch;
import searches.SequentialSearch;
import sorts.HeapSort;
import sorts.InsertionSort;
import sorts.MergeSort;
import sorts.QuickSort;
import sorts.SelectionSort;

public class Main {

	public static void main(String[] args) {
		
		// TODO: To see variations in time scale for sorts, change arraySize to larger numbers
		// NOTE: Large data sets (100000+) will cause Selection and Insertion Sort to go slowly
		//		 Be patient with it!
		arraySize = 10;
		
		
		// SORTS ------------------------------------------------------------
		
		// TODO: Choose which sorts you would like to see. Set to false to disable sort.
		// NOTE: With very large data sets, Selection and Insertion Sorts will take a long time.
		quickSortSwitch = false; 		// Quick Sort - Best: O(n log(n)); Average: O(n log(n)); Worst: O(n^2);
		mergeSortSwitch = false;		// Merge Sort - Best: O(n log(n)); Average: O(n log(n)); Worst: O(n log(n));
		heapSortSwitch = true;			// Heap Sort - Best: O(n log(n)); Average: O(n log(n)); Worst: O(n log(n));
		insertionSortSwitch = false; 	// InsertionSort - Best: O(n); Average: O(n^2); Worst: O(n^2);
		selectionSortSwitch = true;		// Selection Sort - Best: O(n^2); Average: O(n^2)); Worst: O(n^2);
		
		// TODO: Enable or disable comments for actions taking place in each sort
		// NOTE: RECOMMENDATIONS:
		//		 Use only one sort type at a time when comments are enabled, otherwise a lot of information will be lost in the console.
		//		 Use a small number for arraySize (IE: 10, 25, or 50) to limit spam.
		//		 	Also, if you run a large array size, it can mess up the output to the console,
		//			giving you useless or garbled information.
		//
		//		 DISABLE COMMENTS TO SEE TRUE RUN TIME NUMBERS
		quickSortComments = false;
		mergeSortComments = false;
		heapSortComments = true;
		insertionSortComments = false;
		selectionSortComments = false;
		
		
		// SEARCHES ----------------------------------------------------------
		
		// TODO: Choose which searches you would like to see. Set to false to disable search.
		// NOTE: These searches use a different data set than the sorts above
		//		 Enter a value to search for below
		valueToSearchFor = 50;			// Select number between 1 and 1000
		binarySearchSwitch = false;		// Binary Search - O(log(n))
		sequentialSearchSwitch = false;	// Sequential Search - O(n)
		
		// TODO: Enable or disable comments for actions taking place in each search
		// NOTE: It's highly recommended to only do one search type at a time when comments are enabled.
		// 		 Otherwise a lot of information will be lost in the console.
		//		 Additionally, use a small number for arraySize (IE: 10) to limit spam.
		//
		//		 DISABLE COMMENTS TO SEE TRUE RUN TIME NUMBERS
		binarySearchComments = false;
		sequentialSearchComments = false;
		
		runSorts();
		runSearches();
	}
	
	// Modifiers
	private static int arraySize;
	private static boolean printArrays = true;
	
	private static boolean quickSortSwitch = true;
	private static boolean mergeSortSwitch = true;
	private static boolean heapSortSwitch = true;
	private static boolean insertionSortSwitch = true;
	private static boolean selectionSortSwitch = true;
	
	private static boolean quickSortComments = false;
	private static boolean mergeSortComments = false;
	private static boolean heapSortComments = false;
	private static boolean insertionSortComments = false;
	private static boolean selectionSortComments = false;
	
	private static int valueToSearchFor;
	private static boolean binarySearchSwitch = true;
	private static boolean sequentialSearchSwitch = true;
	
	private static boolean binarySearchComments = false;
	private static boolean sequentialSearchComments = false;
	
	public static void runSorts(){
		long timeStart;
		long timeEnd;
		if(arraySize >= 1000){
			printArrays = false;
			System.out.println("arraySize is larger than 1000, no arrays will be printed."
					+ "\nPrinting large arrays can interfere with the sorting algorithms and "
					+ "writing to the console."
					+ "\nPlease use a number less than 1000 to see arrays being sorted.");
		}
		
		// Generate our data from arraySize
		DataGenerator data = new DataGenerator(arraySize);
		int[] myData = data.getArray();
		System.out.println("Starting Data: " + arraySize + " items.");
		if(printArrays)
			System.out.println(Arrays.toString(myData));
		
		if(quickSortSwitch){
			// Quick Sort ----------------------------------------
			// Best: O(n log(n)); Average: O(n log(n)); Worst: O(n^2);
			QuickSort quickSort = new QuickSort(myData, quickSortComments);
			timeStart = System.nanoTime();
			quickSort.quickSort(0, arraySize-1);
			timeEnd = System.nanoTime();
			int[] quickSortData = quickSort.getArray();
			System.out.println("\nQuick Sort Result:");
			if(printArrays)
				System.out.println("\n" + Arrays.toString(quickSortData));
			
			System.out.println("Nanoseconds (1/1000000000 seconds) to Quick Sort completion: " + (timeEnd - timeStart) + 
					"\nMilliseconds (1/1000 seconds) to Quick Sort completion: " + (double)(timeEnd - timeStart) / 1000000 +
					"\nSeconds to Quick Sort completion: " + ((double)(timeEnd - timeStart)) / 1000000000);
			// Quick Sort ----------------------------------------
		}
		
		if(mergeSortSwitch){
			// Merge Sort ----------------------------------------
			// Best: O(n log(n)); Average: O(n log(n)); Worst: O(n log(n));
			timeStart = System.nanoTime();
			MergeSort mergeSort = new MergeSort(myData, mergeSortComments);
			timeEnd = System.nanoTime();
			int[] mergeSortData = mergeSort.getArray();
			System.out.println("\nMerge Sort Result:");
			if(printArrays)
				System.out.println("\n" + Arrays.toString(mergeSortData));
			
			System.out.println("Nanoseconds (1/1000000000 seconds) to Merge Sort completion: " + (timeEnd - timeStart) + 
					"\nMilliseconds (1/1000 seconds) to Merge Sort completion: " + (double)(timeEnd - timeStart) / 1000000 +
					"\nSeconds to Merge Sort completion: " + ((double)(timeEnd - timeStart)) / 1000000000);
			// Merge Sort ----------------------------------------
		}
		
		if(heapSortSwitch){
			// Heap Sort ----------------------------------------
			// Best: O(n log(n)); Average: O(n log(n)); Worst: O(n log(n));
			HeapSort heapSort = new HeapSort(myData, heapSortComments);
			timeStart = System.nanoTime();
			heapSort.heapSort();
			timeEnd = System.nanoTime();
			int[] heapSortData = heapSort.getArray();
			System.out.println("\nHeap Sort Result:");
			if(printArrays)
				System.out.println("\n" + Arrays.toString(heapSortData));
			
			System.out.println("Nanoseconds (1/1000000000 seconds) to Heap Sort completion: " + (timeEnd - timeStart) + 
					"\nMilliseconds (1/1000 seconds) to Heap Sort completion: " + (double)(timeEnd - timeStart) / 1000000 +
					"\nSeconds to Heap Sort completion: " + ((double)(timeEnd - timeStart)) / 1000000000);
			// Heap Sort ----------------------------------------
		}
		
		if(insertionSortSwitch){
			// Insertion Sort ------------------------------------
			InsertionSort insertionSort = new InsertionSort(myData, insertionSortComments);
			timeStart = System.nanoTime();
			insertionSort.insertionSort();
			timeEnd = System.nanoTime();
			int[] insertionSortData = insertionSort.getArray();
			System.out.println("\nInsertion Sort Result:");
			if(printArrays)
				System.out.println("\n" + Arrays.toString(insertionSortData));
			
			System.out.println("Nanoseconds (1/1000000000 seconds) to Insertion Sort completion: " + (timeEnd - timeStart) + 
					"\nMilliseconds (1/1000 seconds) to Insertion Sort completion: " + (double)(timeEnd - timeStart) / 1000000 +
					"\nSeconds to Insertion Sort completion: " + ((double)(timeEnd - timeStart)) / 1000000000);
			// Insertion Sort ------------------------------------
		}
		
		if(selectionSortSwitch){
			// Selection Sort ------------------------------------
			// Best: O(n^2); Average: O(n^2)); Worst: O(n^2);
			SelectionSort selectionSort = new SelectionSort(myData, selectionSortComments);		
			timeStart = System.nanoTime();
			selectionSort.selectionSort();
			timeEnd = System.nanoTime();
			int[] selectionSortData = selectionSort.getArray();
			System.out.println("\nSelection Sort Result:");
			if(printArrays)
				System.out.println("\n" + Arrays.toString(selectionSortData));
			
			System.out.println("Nanoseconds (1/1000000000 seconds) to Selection Sort completion: " + (timeEnd - timeStart) + 
					"\nMilliseconds (1/1000 seconds) to Selection Sort completion: " + (double)(timeEnd - timeStart) / 1000000 +
					"\nSeconds to Selection Sort completion: " + ((double)(timeEnd - timeStart)) / 1000000000);
			// Selection Sort ------------------------------------
		}
	}

	public static void runSearches(){
		long timeStart;
		long timeEnd;
		
		if(arraySize >= 1000){
			arraySize = 1000;
		}
		if(valueToSearchFor > 1000){
			valueToSearchFor = (int)(Math.random()*arraySize) + 1;
			System.out.println("valueToSearchFor is larger than 1000. Searching for " + valueToSearchFor + " instead.");
		}
		else if(valueToSearchFor < 0){
			valueToSearchFor = (int)(Math.random()*arraySize) + 1;
			System.out.println("valueToSearchFor is less than 0. Searching for " + valueToSearchFor + " instead.");
		}
		DataGenerator data = new DataGenerator(arraySize);
		int[] myData = data.getArray();
		
		HeapSort heapSort = new HeapSort(myData, false);
		heapSort.heapSort();
		myData = heapSort.getArray();
		
		if(binarySearchSwitch){
			// Binary Search -------------------------------------
			BinarySearch binarySearch = new BinarySearch(myData, binarySearchComments);
			System.out.println("\nBinary Search Results:");
			timeStart = System.nanoTime();
			binarySearch.binarySearchForValue(valueToSearchFor);
			timeEnd = System.nanoTime();
			System.out.println("Nanoseconds (1/1000000000 seconds) to Binary Search completion: " + (timeEnd - timeStart) + 
					"\nMilliseconds (1/1000 seconds) to Binary Search completion: " + (double)(timeEnd - timeStart) / 1000000 +
					"\nSeconds to Binary Search completion: " + ((double)(timeEnd - timeStart)) / 1000000000);
			// Binary Search -------------------------------------
		}
		
		if(sequentialSearchSwitch){
			// Sequential Search -------------------------------------
			SequentialSearch sequentialSearch = new SequentialSearch(myData, sequentialSearchComments);
			System.out.println("\nSequential Search Results:");
			timeStart = System.nanoTime();
			sequentialSearch.sequentialSearch(valueToSearchFor);
			timeEnd = System.nanoTime();
			System.out.println("Nanoseconds (1/1000000000 seconds) to Sequential Search completion: " + (timeEnd - timeStart) + 
					"\nMilliseconds (1/1000 seconds) to Sequential Search completion: " + (double)(timeEnd - timeStart) / 1000000 +
					"\nSeconds to Sequential Search completion: " + ((double)(timeEnd - timeStart)) / 1000000000);
			// Sequential Search -------------------------------------
		}
	}
}
