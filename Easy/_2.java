package Easy;

//Given an array of integers nums, return the second-largest element in the array. If the second-largest element does not exist, return -1.

public class _2 {

    public static int secondLargestElement(int[] nums) {
        if(nums.length== 1) return -1;

        int max= nums[0];

        for(int i=1; i<nums.length; i++){
            max= Math.max(max, nums[i]);
        }

        int secondMax= Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            if(nums[i]!= max) {
                secondMax= Math.max(secondMax, nums[i]);
            }
        }
        return (secondMax== Integer.MIN_VALUE) ? -1: secondMax;
    }

    static void main(String[] args) {
        int result= secondLargestElement(new int []{-5, -2, -8});
        System.out.println(result);
//        System.out.println(Integer.MIN_VALUE);
    }
}
