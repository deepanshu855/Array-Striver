package Medium;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.

import java.util.HashMap;
import java.util.Map;

public class _1 {
    public static void twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm= new HashMap<>();

        int j=0;
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], target-nums[i]);
        }
    }

    static void main(String[] args) {
        twoSum(new int[]{2,7,11,15}, 9);
    }
}
