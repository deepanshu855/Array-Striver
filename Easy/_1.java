package Easy;

//Given an array of integers nums, return the value of the largest element in the array

public class _1 {
    public static int largestElement(int[] nums) {

        int max= nums[0];

        for(int i=1; i<nums.length; i++){
            max= Math.max(max, nums[i]);
        }

        return max;
    }

    static void main(String[] args) {
        int result= largestElement(new int []{-5, -2, -8});
        System.out.println(result);
    }
}
