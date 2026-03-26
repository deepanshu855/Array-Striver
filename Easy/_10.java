package Easy;

//Given an integer array of size n containing distinct values in the range from 0 to n (inclusive), return the only number missing from the array within this range.

public class _10 {
    // Better solution but takes O(N) space complexity
    public static int missingNumber(int[] nums) {
        int[] ht= new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            ht[nums[i]]++;
        }

        for(int i=0; i<ht.length; i++){
            if(ht[i]==0){
                return i;
            }
        }
        return 0;
    }

    // Optimal using sum 0(1) sc
    public static int missingNumberSum(int[] nums) {
        int n= nums.length;
        int sum= (n*(n+1))/2;

        int sum2=0;
        for (int i=0; i<n; i++){
            sum2+= nums[i];
        }
        return (sum-sum2);
    }

    // In sum case the same may overflow for array size 10^5. Hence we need to use long or we can use XOR;
    public static int missingNumberXOR(int[] nums) {
        int XOR1=0, XOR2= 0;
        for(int i=0; i<nums.length; i++){
            XOR1= XOR1^nums[i];
            XOR2= XOR2^(i+1);
        }
        return (XOR1^XOR2);
    }


    static void main(String[] args) {
        int result= missingNumberXOR(new int[]{0, 1});
        System.out.println(result);
    }
}
