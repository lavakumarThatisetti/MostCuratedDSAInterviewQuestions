package arrays;



/*
[1,2,3,4,5,6,7] ,  k = 3 = k = k%n

break at n-k

[1,2,3,4] [5,6,7]

[4 3 2 1] [7 6 5]

[5 6 7 1 2 3 4]

o(n)

 */


// https://leetcode.com/problems/rotate-array/solutions/1730142/java-c-python-a-very-very-well-detailed-explanation/
public class RotateArray_189 {

    /*
    So, in order to rotate this Array k times what we will do is, we will reverse the P1 first which become [4,3,2,1] & then we reverse P2 which becomes [7,6,5]
Now finally what we have to do is we gonna reverse the complete array by doing that what will happen is our array become [5,6,7,1,2,3,4] and that's what we want in our Output
    */
    public static void reverse(int nums[], int i, int j){
        int li = i;
        int ri = j;

        while(li < ri){
            int temp = nums[li];
            nums[li] = nums[ri];
            nums[ri] = temp;

            li++;
            ri--;
        }
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k < 0){
            k += nums.length;
        }
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        rotate(arr, 3);
        for (int val: arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }
}
