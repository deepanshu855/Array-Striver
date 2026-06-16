package Hard;
import java.util.*;
//Largest Subarray with Sum 0

import java.util.HashMap;

public class _5 {
    // Brute force
    public static int maxLen(int[] arr) {
        int len=0;

        for(int i=0; i<arr.length; i++){
            int sum=arr[i];
            for(int j=i+1; j<arr.length; j++){
                sum+=arr[j];
                if(sum==0){
                    len= Math.max(len, j-i+1);
                }
            }
        }

        return len;
    }

    // Optimal approach
    public static int maxLenOptilam(int[] arr){
        int len=0;
        int sum=0;
        Map<Integer, Integer> hm= new HashMap<>();

        for(int i=0; i<arr.length; i++){
            sum+=arr[i];

            if(sum==0){
                len=i+1;
            } else {
                if(hm.containsKey(sum)){
                    len=Math.max(len, i-hm.get(sum));
                } else {
                    hm.put(sum, i);
                }
            }
        }

        return len;
    }

    static void main(String[] args) {
        int result= maxLenOptilam(new int[] {15, -2, 2, -8, 1, 7, 10, 23});
        System.out.println(result);
    }
}
