package Hard;
import java.util.*;

//Count subarrays with given xor K

public class _6 {
    // Brute
    public static int subarraysWithXorKBrute(int[] nums, int k) {
        int n=nums.length;
        int solution=0;

        for(int i=0; i<n; i++){
            int xor= nums[i];
            if (xor==k) solution++;
            for(int j=i+1; j<n; j++){
                xor^=nums[j];
                if(xor==k) solution++;
            }
        }

        return solution;
    }

    // Optimal approach
    public static  int subarraysWithXorK(int[] nums, int k){
        int n=nums.length;
        int cnt=0;

        Map<Integer,Integer> hm= new HashMap<>(); // To store (frontXOR:XR, count)
        int xr=0;
        hm.put(xr,1);

        // 1. We'll calculate frontXOR or xr.
        // 2. We'll check that xr contains the subarray with xor k
        // 3. to check we find x. using formula x=xr^k. if the hashMap contains this we'll increment the cnt. and if not we'll add xr to hashMap.

        for(int i=0; i<n; i++){
            xr^=nums[i];
            int x= xr^k;
            if(hm.containsKey(x)){
                cnt+= hm.get(x);
            }

            if(!hm.containsKey(xr)){
                hm.put(xr,1);
            } else {
                int temp=hm.get(xr)+1;
                hm.put(xr,temp);
            }
        }

        return cnt;
    }

    static void main(String[] args) {
        int ans= subarraysWithXorK(new int[]{4, 2, 2, 6, 4}, 6);
        System.out.println(ans);
    }
}
