# Algorithm-Studies
Studying searching and sorting algorithms. Decided to make it into something people could use to see and understand (hopefully) how each one works. Feel free to dive into the classes and the code to see comments on each step, and see how it executes.  

# How to use:
Clone, then open in your Java IDE client (Eclipse is free here: https://eclipse.org/home/index.php).  
Open main.java. Most of the instructions are in the comments, but I'll put them here too:
### Variables to change to see different sorts and searches, with or without comments:
- **arraySize**: Change this to set different sizes of arrays, and time scaling for each sorting algorithm.  
- **Sorts Switches**:
    - **quickSortSwitch**: True/False. Makes the program run a Quick Sort algorithm on the generated data.
    - **mergeSortSwitch**: True/False. Makes the program run a Merge Sort algorithm on the generated data.
    - **heapSortSwitch**: True/False. Makes the program run a Heap Sort algorithm on the generated data.
    - **insertionSortSwitch**: True/False. Makes the program run an Insertion Sort algorithm on the generated data.
    - **selectionSortSwitch**: True/False. Makes the program run a Selection Sort algorithm on the generated data.
- **Comments Switches**: Highly recommended to use only one of these at a time, with a small data set (ex: 10, 25, or 50).
    - **quickSortComments**: True/False. Makes the program show comments in the console for each step in the Quick Sort algorithm.
    - **mergeSortComments**: True/False. Makes the program show comments in the console for each step in the Merge Sort algorithm.
    - **heapSortComments**: True/False. Makes the program show comments in the console for each step in the Heap Sort algorithm
    - **insertionSortComments**: True/False. Makes the program show comments in the console for each step in the Insertion Sort algorithm.
    - **selectionSortComments**: True/False. Makes the program show comments in the console for each step in the Selection Sort algorithm.
- **Search Switches**:
    - **valueToSearchFor**: Can be anything between 1 and 1000.
    - **binarySearchSwitch**: True/False. Will run a binary search on data generated. Will only return 1 value.
    - **sequentialSearchSwitch**: True/False. will run a sequential search on data generated. Can return more than 1 value.
