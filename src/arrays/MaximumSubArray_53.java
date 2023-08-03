package arrays;

public class MaximumSubArray_53 {
    public static int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int maxSoFar=nums[0], maxEndingHere=nums[0];
        for(int i=1;i<nums.length;i++){
            maxEndingHere = Math.max(nums[i],maxEndingHere+nums[i]);
            maxSoFar = Math.max(maxSoFar,maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
