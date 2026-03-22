package Easy;

//Given an integer array nums, move all the 0's to the end of the array. The relative order of the other elements must remain the same.
//This must be done in place, without making a copy of the array.

import java.util.Arrays;

public class _7 {
    public static void moveZeroes(int [] nums){
        int zeroCount= 0;
        int j= 0;
        for (int i=0; i<nums.length; i++){
            if(nums[i]==0){
                zeroCount++;
            } else {
                nums[j]= nums[i];
                j++;
            }
        }

        for(int i=0; i<zeroCount; i++){
            nums[j]= 0;
            j++;
        }
    }

    static void main(String[] args) {
        int [] nums= {0, 1, 4, 0, 5, 2};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
