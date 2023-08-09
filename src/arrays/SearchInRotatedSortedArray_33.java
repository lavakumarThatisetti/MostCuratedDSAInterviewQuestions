package arrays;

public class SearchInRotatedSortedArray_33 {

    public static int search(int[] nums, int target) {
        int l=0,h=nums.length-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(target==nums[mid])
                return mid;
                //if left part is monotonically increasing, or the pivot point is on the right part
            else if(nums[l]<=nums[mid]){
                //must use ">=" at here since we need to make sure target is in the left part,
                //then safely drop the right part
                if(target<nums[mid] && target >= nums[l]){
                    h = mid-1;
                }else{
                    l=mid+1;
                }

            }else{
                // the right half is monotonic, yet still does not satisfy
                if(target < nums[l]  && target > nums[mid]){
                    l=mid+1;
                }else{
                    h=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
    }
}
