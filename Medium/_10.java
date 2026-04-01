package Medium;

//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//You must write an algorithm that runs in O(n) time.
//Example 1:
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _10 {
    // Brute force
    public static int longestConsecutiveBrute(int[] nums) {
        // Brute force.
        // Iterate over the whole array.
        // Linear Search the entire array for arr[i]+1 and increase the count, if found.
        int longest=0;
        for(int i=0; i<nums.length; i++){
            int x= nums[i];
            int count=1;
            while(ls(nums, x+1)== true){
                x=x+1;
                count=count+1;
            }
            longest= Math.max(longest, count);
        }
        return longest;
    }

    // Linear Search
    public static boolean ls(int[] nums, int next){
        for(int i=0; i<nums.length; i++){
            if(nums[i]== next) return true;
        }
        return false;
    }

    // Better Approach
    public int longestConsecutive(int[] nums) {
        // This is better approac.
        // Here we first sort the array.
        // we keep track of the lastValue and increment according to it.

        if(nums.length==0) return 0;

        Arrays.sort(nums);
        int longest=1;
        int lastValue=Integer.MIN_VALUE;
        int count=1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]-1== lastValue){
                count++;
                lastValue= nums[i];
            } else if (nums[i]!= lastValue){
                count=1;
                lastValue= nums[i]; //1
            }

            longest=Math.max(longest, count); //1
        }
        return longest;
    }

    // Optimal. given by striver par leetcode pe sort vali approach zyada better aa rhi hai.
    public static int longestConsecutiveOptimal(int[] nums) {
        // Optimal Approach.
        // Store element in a HashSet.
        // check if the current element is a starting point or a not we do not increment count for the mid element.
        // iterate over the set and if the current element - 1 -> is in set then this is not the starting element.
        // if current element - 1 -> is not in the set, then this is the starting element and now check for the curr element + 1 and increment the count.

        Set<Integer> st= new HashSet<>();
        int longest=0;
        for(int i=0; i<nums.length; i++){
            st.add(nums[i]);
        }

        // [1, 2, 6, 7, 8]
        for(var it:st){
            if(st.contains(it-1)){
                continue;
            } else { // !st.contains(it-1)
                int count=0;
                while(st.contains(it)){
                    count++;
                    it= it+1;
                }
                longest= Math.max(longest, count);
            }
        }
        return longest;
    }

    static void main(String[] args) {
        int result= longestConsecutiveOptimal(new int[]{0,3,7,2,5,8,4,6,0,1});
        System.out.println(result);
    }
}
