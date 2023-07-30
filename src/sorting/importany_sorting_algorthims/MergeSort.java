package sorting.importany_sorting_algorthims;

import java.util.Arrays;

/*
Merge Sort is one of the most popular and important sorting algorithms
that is based on the principle of Divide and Conquer Algorithm.

Suppose we had to sort an array A. A subproblem would be to sort a sub-section of this array starting
at index p and ending at index r, denoted as A[p..r].

Divide

If q is the half-way point between p and r, then we can split the subarray A[p..r] into two arrays A[p..q]
and A[q+1, r].

Conquer

In the conquer step, we try to sort both the subarrays A[p..q] and A[q+1, r]. If we haven't yet reached
the base case, we again divide both these subarrays and try to sort them.

Combine

When the conquer step reaches the base step and we get two sorted subarrays A[p..q] and A[q+1, r] for
array A[p..r], we combine the results by creating a sorted array A[p..r] from two sorted subarrays A[p..q]
and A[q+1, r]


 */
public class MergeSort {

    private static void mergeSort(int[] arr,int start,int end){
        if(start<end){
            int mid=(end+start)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }
    private static void merge(int[] arr, int start, int mid, int end){

        int n1=mid-start+1;
        int n2=end-mid;

        int[] L=new int[n1];
        int[] R=new int[n2];
        for(int i=0;i<n1;i++){
            L[i]=arr[start+i];
        }
        for(int j=0;j<n2;j++){
            R[j]=arr[mid+1+j];
        }
        int i=0,j=0,k=start;
        while(i<n1&&j<n2){
            if(L[i]<=R[j]){
                arr[k]=L[i];
                i++;
            }else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }

    private static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr={10,5,2,6,11,4,3,1,2,3,4,96666555,6,6,9,11,1111111,19,4,15,2};
        long start=System.currentTimeMillis();
        mergeSort(arr,0,arr.length-1);
        printArray(arr);
        long end=System.currentTimeMillis();
        System.out.println("Latency "+(end-start));
    }
}

