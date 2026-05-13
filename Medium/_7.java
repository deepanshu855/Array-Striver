package Medium;

//You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
//You should return the array of nums such that the array follows the given conditions:
//
// 1. Every consecutive pair of integers have opposite signs.
// 2. For all integers with the same sign, the order in which they were present in nums is preserved.
// 3. The rearranged array begins with a positive integer.
// 4. Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

import java.util.*;

public class _7 {
    public static int[] rearrangeArray(int[] nums) {
        int[] result= new int[nums.length];
        int j=0;
        int k=1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                result[j]=nums[i];
                j= j+2;
            } else {
                result[k]=nums[i];
                k= k+2;
            }
        }
        return result;
    }

    // Alternate Number- another version of this question.- Code need to be done
    public static int[] alternateNumber(int[] nums){
        List<Integer> positives= new ArrayList<>();
        List<Integer> negatives= new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i]>0) positives.add(nums[i]);
            else negatives.add(nums[i]);
        }

        int[] answer= new int[nums.length];

        if(positives.size()>negatives.size()){
            int idx=0;
            for(int i=idx; i<negatives.size(); i++){
                answer[2*idx]= positives.get(i);
                answer[2*idx+1]= negatives.get(i);
                idx++;
            }

            int k=2*idx;
            for(int i=idx; i<positives.size(); i++){
                answer[k++]= positives.get(i);
            }
        } else {
            int idx=0;
            for(int i=idx; i<positives.size(); i++){
                answer[2*idx]= positives.get(i);
                answer[2*idx+1]= negatives.get(i);
                idx++;
            }

            int k=2*idx;
            for(int i=idx; i<negatives.size(); i++){
                answer[k++]= negatives.get(i);
            }
        }

        return answer;
    }

    static void main(String[] args) {
        int[] ans= rearrangeArray(new int[]{3,1,-2,-5,2,-4});
        int[] result= alternateNumber(new int[]{1,2,-4,-5,3,60});
        System.out.println(Arrays.toString(result));
    }
}
