package Easy;

//Given a binary array nums, return the maximum number of consecutive 1's in the array.

public class _11 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxOne=0;
        int result= maxOne;
        for (int i=0; i<nums.length; i++){
            if(nums[i]== 0) maxOne= 0;
            else {
                maxOne++;
            }
            result= Math.max(result, maxOne);
        }
        return result;
    }

    static void main(String[] args) {
        int result= findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1});
        System.out.println(result);
    }
}
