package Hard;
// Maximum Product subarray.

public class _12 {
    // Brute force : to generate all subarrays -> find the product of all subarrays -> return the maximum product

    // This is optimal approach
    public static int maxProduct(int[] nums) {
        int result=nums[0];
        int maxP=nums[0];
        int minP=nums[0];

        for(int i=1; i<nums.length; i++){
            // For positive we +ve X +ve
            if(nums[i]>=0){
                maxP=Math.max(nums[i],maxP*nums[i]);
                minP=Math.min(nums[i],minP*nums[i]);
            } else {
                int temp=maxP; // Since maxP will be change and we cannot use changed max to calculate minP
                maxP=Math.max(nums[i],minP*nums[i]);
                minP=Math.min(nums[i],temp*nums[i]);
            }

            result= Math.max(result,maxP);
        }

        return result;
    }

    static void main(String[] args) {
        int result= maxProduct(new int[]{2,3,-2,4});
        System.out.println(result);
    }
}
