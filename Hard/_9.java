package Hard;
//Find the repeating and missing number

import java.util.Arrays;

public class _9 {
    // Better approach
    public static int[] findMissingRepeatingNumbers(int[] nums) {
        int[] hasharr= new int[nums.length+1];

        // Pre computing
        for(int i=0; i<nums.length; i++){
            hasharr[nums[i]]++;
        }

        int repeating=-1; int missing=-1;

        for(int i=1; i<hasharr.length; i++){
            if(hasharr[i]==2) repeating=i;
            else if(hasharr[i]==0) missing=i;

            if(repeating!=-1 && missing!=-1) break;
        }

        return new int[]{repeating, missing};
    }

    // Optimal approach using maths takes O(1) space.
    public static int[] findMissingRepeatingNumbersOptimal(int[] nums) {
        // We need to take everything in long.
        long n= nums.length;

        // We'll create 2 equations. S-SN and S2-S2N.
        long SN= (n*(n+1))/2; //Sun of n natural no.
        long S2N= (n*(n+1)*((2*n)+1))/6; //Sum of square of n natural no.

        long S=0; long S2=0;
        for(int i=0; i<n; i++){
            S+=nums[i];
            S2+=(long)nums[i]*nums[i];
        }

        long val1= S-SN; // X-Y
        long val2= S2-S2N;
        val2= val2/val1; // X+Y

        long X=(val1+val2)/2;
        long Y=val2-X;

        return new int[]{(int)X, (int)Y};
    }

    static void main(String[] args) {
        int[] result= findMissingRepeatingNumbersOptimal(new int[]{1, 2, 3, 6, 7, 5, 7});
        System.out.println(Arrays.toString(result));
    }
}
