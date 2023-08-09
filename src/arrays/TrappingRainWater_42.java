package arrays;

public class TrappingRainWater_42 {

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int ans =0;
        while(left<right){
            if(height[left]<height[right]) {
                if(height[left]>leftMax){
                    leftMax = height[left];
                }else{
                    ans = ans +leftMax -height[left];
                }
                left++;
            }else{
                if(height[right]>rightMax){
                    rightMax = height[right];
                }else{
                    ans = ans + rightMax -height[right];
                }
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
