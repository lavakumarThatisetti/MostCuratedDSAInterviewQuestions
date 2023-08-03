package arrays;

public class MedianOfTwoSortedArrays_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return MedianSameSize(nums1,nums2);

    }
    private static double MedianSameSize(int[] arr1,int[] arr2){
        // make sure a1 is shorter
        if(arr1.length>arr2.length){
            return MedianSameSize(arr2,arr1);
        }
        int x=arr1.length;
        int y=arr2.length;
        int low=0;
        int high=x;
        while(low<=high){
            // For First Array Cut we need to cut1 based on Low and High as these values holds first array starting and ending length
            int cut1=(low+high)/2;
            // For Second array cut first we need total length combining both array (x+y) then we divide by 2 and then we need to remove the 1st array cut.
            int cut2=(x+y)/2-cut1;

            // conditions to get the 4 values and handle boundary conditions
            int l1=(cut1==0)?Integer.MIN_VALUE:arr1[cut1-1];
            int l2=(cut2==0)?Integer.MIN_VALUE:arr2[cut2-1];
            int r1=(cut1==x)?Integer.MAX_VALUE:arr1[cut1];
            int r2=(cut2==y)?Integer.MAX_VALUE:arr2[cut2];


            // treat cut1 as a mid
            // if l1>l2 which means first array has larger values compared to second array
            // we should decrease high ( not required those values) means decrement high
            if(l1>r2) high = cut1-1;
            // if l2>r1 then fromm array1 we move right which means increase low
            else if(l2>r1) low = cut1+1;
            else {
                // Boundary condition
                /*
                 1 2
                 3 4
                Max (1,3) + Min(2,4)   for even

                 1 2
                 3
                 Min(r1, r2) = (2,3) for odd
                 */
                if((x+y)%2==0)
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                else
                    return Math.min(r1,r2);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2};
        int[] arr2 = {3,4};
        System.out.println(findMedianSortedArrays(arr1,arr2));
    }
}
