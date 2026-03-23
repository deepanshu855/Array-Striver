package Easy;

//Given an array nums of n integers, return true if the array nums is sorted in non-decreasing order or else false.
//Example 1
//Input : nums = [1, 2, 3, 4, 5]
//Output : true
//Explanation : For all i (1 <= i <= 4) it holds nums[i] <= nums[i+1], hence it is sorted and we return true.

import java.util.ArrayList;
import java.util.Arrays;

public class _3 {
    public static boolean isSorted(ArrayList<Integer> nums) {
        for(int i=1; i<nums.size(); i++){
            if(nums.get(i-1)>=nums.get(i)){
                return false;
            }
        }
        return true;
    }

    static void main(String[] args) {
        boolean result= isSorted(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println(result);
    }
}
