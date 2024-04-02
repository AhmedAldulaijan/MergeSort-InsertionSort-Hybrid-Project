The following is an Algorithms Course Project. 
The Objective was to create a modified MergeSort that includes insertion sort, such that a more efficient algorithm may be created.
MergeSort is a relatively fast algorithm, but may fall behind insertionSort in certain edge cases.
An example of such cases is when provided a (mostly) sorted array. MergeSort will take as much time regardless of how sorted the array is, while insertion sort may run fasted.
Through this project, I was able to determine a relative region (Array Size) in which switching to insertion sort is faster overall. 
This was done through a process of running the Mergesort portion of the code, and having it call upon the Insertion sort each time the array becomes smaller than a value n.
