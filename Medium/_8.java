package Medium;

//A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
//The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
//For example, the next permutation of arr = [1,2,3] is [1,3,2].
//Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
//While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
//Given an array of integers nums, find the next permutation of nums.

import java.util.Arrays;

public class _8 {
    // Brute Force-
    // 1. Generate all permuations (this is done with the help of recursion)
    // 2. Linear search the given permuations.
    // 3. index+1 permuation is the answer. if not index+1 then the first permuation is the answer.
    // Give only brute force idea to the interviewer because not implement.

    // Optimal:
    public static void nextPermutation(int[] nums) {
        // 1. Find breaking point i.e the logest prefix.
        int idx=-1;
        for(int i=nums.length-1; i>0; i--){
            if(nums[i]>nums[i-1]){
                idx=i-1;
                break;
            }
        }

        if(idx==-1){
            reverse(nums, 0, nums.length-1);
        } else {
            // 2. Find the no. to replace with breaking point.
            for(int i=nums.length-1; i>=idx; i--){
                if(nums[i]>nums[idx]){
                    int temp= nums[i];
                    nums[i]= nums[idx];
                    nums[idx]= temp;
                    break;
                }
            }

            // 3. Reverse the array i.e part which is not the suffix
            reverse(nums, idx+1, nums.length-1);
        }
    }

    public static void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp= nums[start];
            nums[start]= nums[end];
            nums[end]= temp;

            start++;
            end--;
        }
    }

    static void main(String[] args) {
        int[] nums= {1,1,5};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
