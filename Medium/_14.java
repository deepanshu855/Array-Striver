package Medium;
import java.util.*;


//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

public class _14 {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);

        int preSum = 0, cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];

            int remove = preSum - k;

            cnt += mpp.getOrDefault(remove, 0);

            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }

        return cnt;
    }

    static void main(String[] args) {
        int ans= subarraySum(new int[]{10, 5, 2, 7, 1, 9}, 15);
        System.out.println(ans);
    }
}
