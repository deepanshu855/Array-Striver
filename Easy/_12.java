package Easy;

//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//You must implement a solution with a linear runtime complexity and use only constant extra space.

public class _12 {
    public static int singleNumber(int[] nums) {
        int xor=0;
        for (int i=0; i<nums.length; i++){
            xor= xor^nums[i];
        }
        return xor;
    }

    static void main(String[] args) {
        int result= singleNumber(new int[]{4,1,2,1,2});
        System.out.println(result);
    }
}
