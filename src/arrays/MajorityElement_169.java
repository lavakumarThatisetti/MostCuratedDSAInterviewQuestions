package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {

    // Sorting
    public int majorityElementSorting(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // Hashtable
    public int majorityElementHashTable(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret=0;
        for (int num: nums) {
            map.put(num,map.getOrDefault(num,0)+1);
            if (map.get(num)>nums.length/2) {
                ret = num;
                break;
            }
        }
        return ret;
    }

    /*
        (ans, count)
        (-1,   0)

        [2,       2,        1,        1,     1,     2,     2]
        (2, -1), (2,-2) , (2, -1), (2,0 ), (1,-1), (1,0), (2,-1) != ++
        (2, 1), (2,2),     (2,1), (2, 0), (1, 1), (1,0), (2, 1) != --

        i = 0 to n
         if count == 0  ans =  arr[i]

         if(arr[i] != ans)
            count--;
         else
            count++;
     */
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = -1;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if(num!=candidate) count++;
            else count--;
        }

        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
