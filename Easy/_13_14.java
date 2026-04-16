package Easy;

//Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.

import java.util.*;

public class _13_14 {
    // Brute force
    public static int longestSubarrayBrute(int[] nums, int k) {
        int result=0;
        for(int i=0; i<nums.length; i++){
            int sum=0;
            for(int j=i; j<nums.length; j++){
                sum+=nums[j];
                if(sum== k) {
                    result= Math.max(result, j-i+1);
                    break;
                }
                if(sum> k) break;
            }
        }
        return result;
    }

    // Optimal- This is optimal if the array contains both negative and positive nos. but if array contains only positive no. we can write more optimal approach.
    public static int longestSubarrayOptimal(int[] nums, int k) {
        Map<Integer, Integer> hm= new HashMap<>();
        int prefixSum=0;
        int len= 0;

        for(int i=0; i<nums.length; i++){
            prefixSum+= nums[i];
            int diff= prefixSum-k;

            if(prefixSum== k){
                len= Math.max(len, i+1);
            }
            if(hm.containsKey(diff)){
                len= Math.max(len, i-hm.get(diff));
            }
            if(!hm.containsKey(prefixSum)){
                hm.put(prefixSum, i);
            }
        }
        return len;
    }

    // Optimal if array contains positive and zero- TWO POINTER;
    public static int longestSubarrayPositive(int[] nums, int k){
        int len=0;
        int j=0;
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i]; // 1 3 6 7
            if(sum>k){ // 7
                while(sum>k){
                    sum-=nums[j];// 6
                    j++; // 1
                }
            }
            if(sum== k){
                len= Math.max(len, i-j+1); // 3
            }
        }

        return len;
    }

    static void main(String[] args) {
//        int result= longestSubarrayBrute(new int[]{0, 5, 2, 7, 1, 9}, 8);
        int result= longestSubarrayOptimal(new int[]{10, 5, 2, 7, 1, 9}, 15);
        System.out.println(result);
    }
}
