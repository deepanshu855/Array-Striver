package Easy;

//Given an integer array nums and a non-negative integer k, rotate the array to the left by k  1
//Input: nums = [1, 2, 3, 4, 5, 6], k = 2
//Output: nums = [3, 4, 5, 6, 1, 2]
//Explanation:
//rotate 1 step to the left: [2, 3, 4, 5, 6, 1]
//rotate 2 steps to the left: [3, 4, 5, 6, 1, 2]

import java.util.Arrays;

public class _6 {
    public static void rotateArray(int[] nums, int k) {
        k= k%nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);

    }

    public static void reverse(int [] nums, int start, int end){
        while(start<end){
            int temp= nums[start];
            nums[start]= nums[end];
            nums[end]= temp;

            start++;
            end--;
        }
    }

    static void main(String[] args) {
        int [] nums= {1, 2, 3, 4, 5, 6};
        rotateArray(nums, 2);
    }
}
