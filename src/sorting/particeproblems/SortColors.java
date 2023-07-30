package sorting.particeproblems;

/*
Certainly! The Dutch National Flag problem is a sorting problem that involves arranging an array containing
only the values 0, 1, and 2 in a specific order.

The goal is to sort the array in-place, meaning you can't use extra memory to create a new sorted array.

Here's the problem in simple terms:

Imagine you have a bag of colored balls, and the balls come in three colors: red (0), white (1), and blue (2).
However, the balls are all mixed up, and you want to sort them so that all the red balls are on one side,
all the white balls are in the middle, and all the blue balls are on the other side.

To solve the Dutch National Flag problem, you can use a clever technique called the "Three-Way Partitioning" algorithm. It works like this:

1. Initialize three pointers: one for the start of the array (let's call it "low"),
one for the end of the array (let's call it "high"), and one to traverse the array (let's call it "current").

2. Start traversing the array with the "current" pointer from the beginning (low) of the array.

3. If the value at the "current" pointer is 0 (red ball), swap it with the value at the "low" pointer.
This ensures that the red balls are moved to the leftmost part of the array.

4. If the value at the "current" pointer is 2 (blue ball), swap it with the value at the "high" pointer.
This ensures that the blue balls are moved to the rightmost part of the array.

5. If the value at the "current" pointer is 1 (white ball), simply move to the next element (increment the
"current" pointer).

6. Repeat steps 3 to 5 until the "current" pointer crosses the "high" pointer.

At this point, the array will be sorted with all the red balls (0s) on the left, followed by the white
balls (1s) in the middle, and all the blue balls (2s) on the right.

This algorithm sorts the array in-place with a single pass through the array,
and it works efficiently for the Dutch National Flag problem!

 */
public class SortColors {
    public static void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        while (i <= end) {
            if (nums[i] == 0) {
                swap(nums, i, start);
                start++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i,end);
                end--;
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for (int i: nums){
            System.out.print(i+" ");
        }
        System.out.println();

    }
}
