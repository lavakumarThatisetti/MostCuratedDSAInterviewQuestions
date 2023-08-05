package arrays;

import java.util.HashMap;

public class TwoSum_1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int left = target - nums[i];
            if(map.containsKey(left)){
                return new int[]{i,map.get(left)};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array = {2,7,11,15};
        int[] ans = twoSum(array, 9);
        System.out.println(ans[0]+"  "+ans[1]);
    }
}
