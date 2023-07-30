package sorting.importany_sorting_algorthims;

import java.util.Random;

/*

Quicksort is a sorting algorithm based on the divide and conquer approach where
1. An array is divided into subarrays by selecting a pivot element (element selected from the array).
2. While dividing the array, the pivot element should be positioned in such a way that elements less than
pivot are kept on the left side and elements greater than pivot are on the right side of the pivot.
3. The left and right subarrays are also divided using the same approach. This process continues until each
subarray contains a single element.
4. At this point, elements are already sorted. Finally, elements are combined to form a sorted array.

 */
public class QuickSort {

    public static void quick(int[] arr, int left, int right){
        if(left<right){
            int pIndex = partition(arr,left,right);
            quick(arr,left,pIndex-1);
            quick(arr,pIndex+1,right);
        }
    }
    /*
    Selecting Pivot as the Right Most element
     */
    private static int partition(int[] arr,int left,int right){

        int pivot=arr[right]; // Right most element
        int pIndex=left;
        for(int i=left;i<right;i++){
            if(arr[i]<pivot){
                int temp=arr[pIndex];
                arr[pIndex]=arr[i];
                arr[i]=temp;
                pIndex++;
            }
        }
        int temp=arr[pIndex];
        arr[pIndex]=arr[right];
        arr[right]=temp;
        return pIndex;
    }
    /*
    Selecting Pivot in Random.
    */
    private static int randPartition(int[] arr,int left,int right){
        Random rand=new Random();
        int index=rand.nextInt(right-left);
        int temp=arr[index];
        arr[right]=arr[index];
        arr[index]=temp;
        return partition(arr,left,right);
    }
    private static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr={10,5,2,6,11,4,3,1,2,3,4,96666555,6,6,9,11,1111111,19,4,15,2};
        long start=System.currentTimeMillis();
        quick(arr,0,arr.length-1);
        printArray(arr);
        long end=System.currentTimeMillis();


        System.out.println("Latency "+(end-start));
    }
}
