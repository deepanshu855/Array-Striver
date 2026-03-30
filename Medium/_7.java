package Medium;

//You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
//You should return the array of nums such that the array follows the given conditions:
//
// 1. Every consecutive pair of integers have opposite signs.
// 2. For all integers with the same sign, the order in which they were present in nums is preserved.
// 3. The rearranged array begins with a positive integer.
// 4. Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

public class _6 {
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

    static void main(String[] args) {
        int[] ans= rearrangeArray(new int[]{3,1,-2,-5,2,-4});
    }
}
