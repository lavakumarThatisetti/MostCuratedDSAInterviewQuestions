package arrays;

public class FirstMissingPositive_41 {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
        // (we can ignore those because if all number are > n then we'll simply return 1)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        // note: all number in the array are now positive, and on the range 1..n+1

        // 2. mark each cell appearing in the array, by converting the index for that number to negative
        for (int i = 0; i < n; i++) {
            /*
            Example: nums = [3,4,-1,1]
Step 1: mark negative and numbers greater than "n" as "n+1"
we get, [3,4,5,1]
Step 2: Take each absolute value in array,
 reduce it by one and mark the particular index as negative.So, we get [3,4,-5,1] when i= 0 and nums[i] =3 , similarily, when we take i=1, nums[i] = 4 , so at index= 3 make the value negative. Now, when i=2, if we don't take absolute value we get "-5", where nums[-5] gives, "index out of bound exception" so, we take absolute value.
*/
            int num = Math.abs(nums[i]);
            // Skip > n not require
            if (num > n) {
                continue;
            }
            num--; // -1 for zero index based array (so the number 1 will be at pos 0)
            if (nums[num] > 0) { // prevents double negative operations
                nums[num] = -1 * nums[num];
            }
        }
        // 3. find the first cell which isn't negative (doesn't appear in the array)
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        // 4. no positive numbers were found, which means the array contains all numbers 1..n
        return n + 1;
    }
    public static void main(String[] args) {

        int[] array = {3,4,-1,1};
        System.out.println(firstMissingPositive(array));

        /*
         value from 1 to n ( length of the array)
         correct array = [1,2,3,4] = {0,1,2,3}

         Sol1 = {-1,1,3,4}  if(arr[i]+1 != arr[i+1])  return i+1;  nlogn
                {1,2,3,4}
         Sol2
         1. if you Encounter negative or values>n  = n+1  = {3,4,5,1}
         2. iter 0 to n
               val = abs(arr[i])
               if val > n skip

               if(arr[val] > 0)   arr[val] = - arr[val];
           1st = {    -3, -4,5, -1}
        3. i = 0 to n
           if(arr[i]>n) return i;
         */


    }
}
