package sorting.importany_sorting_algorthims;

import java.util.PriorityQueue;

/*
Heap Sort is a popular and efficient sorting algorithm in computer programming.
used two types of data structures - arrays and trees.

1. Array Represent in Binary Tree
2. Complete Binary Tree
3. Insert & Delete
4. Heapify
5. Priority Queue
 */
public class HeapSorting {
    private int heapSize;
    private final int N;
    private final int[] arr;

    private HeapSorting(int n){
        N=n;
        heapSize=0;
        arr=new int[n];
    }
    private int parent(int i) { return (i-1)/2;}
    private int left(int i){ return (2*i+1);}
    private int right(int i){return (2*i+2);}

    private void insertKey(int val){
        if(heapSize==N){
            System.out.println("OverFlow");
            return;
        }
        int i=heapSize;
        arr[i]=val;

        // after adding value increase the heapSize
        heapSize++;
        // While building max heap during insertion parent value should always greater than child
        // else we should swap parent and child
        while(i!=0 && arr[parent(i)]<arr[i]){
            swap(parent(i),i);
            i=parent(i);
        }
    }
    private void deleteKey(){
        heapSize--; // Decrement
        // always swap root with last element
        swap(0,heapSize);
        heapify(arr, heapSize, 0);
    }
    private void heapify(int[] arr,int n,int rootIndex){
        int maxIndex = rootIndex;
        int lIndex = left(rootIndex);
        int rIndex = right(rootIndex);
        if (lIndex < n && arr[lIndex] > arr[maxIndex])
            maxIndex = lIndex;
        if (rIndex < n && arr[rIndex] > arr[maxIndex])
            maxIndex = rIndex;
        if (maxIndex != rootIndex) {
            swap(rootIndex,maxIndex);
            heapify(arr, n, maxIndex);
        }
    }
    private void swap(int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    private void printArray(){
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] array={15,20,7,9,30};
        long start=System.currentTimeMillis();
        HeapSorting hs=new HeapSorting(array.length);
        for(int i=0;i<array.length;i++){
            hs.insertKey(array[i]);
        }
        hs.printArray();
        for(int i=0;i<array.length;i++){
            hs.deleteKey();
        }
        hs.printArray();
        long end=System.currentTimeMillis();
        System.out.println("Latency "+(end-start));

    }
}
