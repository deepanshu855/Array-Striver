package Hard;
import java.util.*;
// 4 Sum

public class _4 {
    // Better O(n3)
    public static List<List<Integer>> fourSumBetter(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashSet = new HashSet<>();

                for (int k = j + 1; k < n; k++) {
                    long d = (long) target - nums[i] - nums[j] - nums[k];

                    if (hashSet.contains(d)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int) d);

                        Collections.sort(temp);
                        set.add(temp);
                    }

                    hashSet.add((long) nums[k]);
                }
            }
        }

        return new ArrayList<>(set);
    }

    // Optimal
    public static List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        int n= nums.length;
        Arrays.sort(nums);

        Set<List<Integer>> quadraplets= new HashSet<>();

        for(int i=0; i<n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;

            for(int j=i+1; j<n; j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;

                int k= j+1;
                int l= n-1;
                while(k<l){
                    long sum= (long)nums[i]+nums[j]+nums[k]+nums[l];

                    if(sum<target){
                        // Move k
                        k++;
                    } else if(sum>target){
                        // Move l
                        l--;
                    } else {
                        List<Integer> temp= new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        quadraplets.add(temp);

                        // Move both k and l
                        k++;
                        while(k<l && nums[k]==nums[k-1]){
                            k++;
                        }

                        l--;
                        while(l>k && nums[l]==nums[l+1]){
                            l--;
                        }
                    }
                }
            }
        }

        return new ArrayList(quadraplets);
    }

    static void main(String[] args) {
        List<List<Integer>> result= fourSumOptimal(new int[]{1,0,-1,0,-2,2}, 0);
        System.out.println(result);
    }
}

