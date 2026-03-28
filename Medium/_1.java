package Medium;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm= new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(target-nums[i])){
                return new int[]{hm.get(target-nums[i]), i};
            }
            hm.put(nums[i], i);
        }
        return null;
    }

    // Variety 1- if we just need to return sum exist or not. 2 Pointer approach.
    public static boolean twoSum1(int [] nums, int target){
        int j=nums.length-1;
        int i=0;
        Arrays.sort(nums);
        while(i<j){
            if(nums[i]+nums[j]== target) return true;
            if(nums[i]+nums[j]<target){
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    static void main(String[] args) {
        int[] result= twoSum(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(result));
        boolean ans= twoSum1(new int[]{3,2,4}, 6);
        System.out.println(ans);
    }
}
