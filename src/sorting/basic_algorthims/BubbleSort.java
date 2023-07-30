package sorting.basic_algorthims;

/*
 Bubble sort is a sorting algorithm that compares two adjacent elements and swaps them until they
 are in the intended order.
 */
public class BubbleSort {
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        // loop to access each array element
        for (int i = 0; i < n - 1; i++)

            for (int j = 0; j < n - i - 1; j++)
                // compare two adjacent elements
                // change > to < to sort in descending order
                if (arr[j] > arr[j + 1]) {
                    // swapping occurs if elements are not in the intended order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    /*
    In the above algorithm, all the comparisons are made even if the array is already sorted. This increases the execution time.

    To solve this, we can introduce an extra variable swapped.

    The value of swapped is set true if there occurs swapping of elements. Otherwise, it is set false.

    After an iteration, if there is no swapping, the value of swapped will be false. This means elements are already sorted and there is no need to perform further iterations.

    This will reduce the execution time and helps to optimize the bubble sort.

     */

    static void bubbleSortOptimization(int[] arr) {

        int n = arr.length;
        // loop to access each array element
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // compare two adjacent elements
                // change > to < to sort in descending order
                if (arr[j] > arr[j + 1]) {
                    // swapping occurs if elements are not in the intended order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // no swapping means the array is already sorted
            // so no need for further comparison
            if(!swapped) return;
        }
    }

    static void printArray(int[] arr) {
        for (int val : arr) System.out.print(val + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = { 15, 20, 7, 9, 30};
        bubbleSortOptimization(arr);
        System.out.println("Sorted array");
        printArray(arr);
    }
}
