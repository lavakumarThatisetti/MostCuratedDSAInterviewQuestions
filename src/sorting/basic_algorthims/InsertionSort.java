package sorting.basic_algorthims;

/*
Insertion sort is a sorting algorithm that places an unsorted element at its suitable place in each iteration.

 */
public class InsertionSort {
    static void insertionSort(int[] array) {
        int size = array.length;
        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;  // Assume already sorted
            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change key<array[j] to key>array[j].
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            // Place key at after the element just smaller than it.
            array[j + 1] = key;
        }
    }

    static void printArray(int[] arr) {
        for (int val : arr) System.out.print(val + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 9, 5, 1, 4, 3 };
        insertionSort(arr);
        System.out.println("Sorted Array in Ascending Order: ");
        printArray(arr);
    }
}
