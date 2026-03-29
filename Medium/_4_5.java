package Medium;

//Given an integer array nums, find the subarray with the largest sum, and return its sum.

public class _4_5 {
    public static int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int currSum=nums[0];
        for(int i=1; i<nums.length; i++){
            if(currSum<0) currSum=0;
            currSum+= nums[i];
            maxSum= Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    // Variety2 - We need to print the subarray with the maximum sum.
    public static void maxSubArrayPrint(int[] nums) {
        int max= Integer.MIN_VALUE;
        int sum=0;
        int start=0, end= nums.length-1;
        for(int i=0; i<nums.length; i++){
            if(sum==0) start=i;
            sum+=nums[i];
            if(sum>max){
                max=sum;
                end=i;
            }
            if(sum<0){
                sum=0;
            }
        }
        for(int i=start; i<=end; i++){
            System.out.print(nums[i]+ " ");
        }
    }

    static void main(String[] args) {
        int result= maxSubArray(new int[]{5,4,-1,7,8});
        System.out.println(result);
        maxSubArrayPrint(new int[]{5,4,-1,7,8});
    }
}
