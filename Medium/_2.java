package Medium;

//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//You must solve this problem without using the library's sort function.

import java.util.Arrays;

public class _2{
    // Brute force for this question is sorting Merge Sort.

    // Better Approach
    public static void sortColors(int[] nums) {
        int cnt0=0;
        int cnt1=0;
        int cnt2=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0) cnt0++;
            else if(nums[i]==1) cnt1++;
            else cnt2++;
        }

        for(int i=0; i<cnt0; i++){
            nums[i]=0;
        }
        for(int i=cnt0; i<cnt0+cnt1; i++){
            nums[i]=1;
        }
        for(int i=cnt0+cnt1; i<nums.length; i++){
            nums[i]=2;
        }
    }

    // Dutch National Flag Algorithm.
    public static void sortColorsDNFA(int[] nums){
        int low= 0;
        int mid= 0;
        int high= nums.length-1;

        while(mid<=high){
            if(nums[mid]== 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if (nums[mid]==1) {
                mid++;
            }
            else{
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp= nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }

    static void main(String[] args) {
        int[] nums= {2,0,2,1,1,0};
//        sortColors(nums);
        sortColorsDNFA(nums);
        System.out.println(Arrays.toString(nums));
    }
}
