package sorting.basic_algorthims;

/*
Selection sort is a sorting algorithm that selects the smallest element from an unsorted list
in each iteration and places that element at the beginning of the unsorted list.
 */
public class SelectionSort {
    static void selectionSort(int[] array) {
        int size = array.length;
        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;
            for (int i = step + 1; i < size; i++) {
                // To sort in descending order, change > to < in this line.
                // Select the minimum element in each loop.
                if (array[i] < array[min_idx]) {
                    min_idx = i;
                }
            }
            // put min at the correct position
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
        }
    }
    static void printArray(int[] arr) {
        for (int val : arr) System.out.print(val + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = { 9, 5, 1, 4, 3 };
        selectionSort(arr);
        System.out.println("Sorted Array in Ascending Order: ");
        printArray(arr);
    }
}
