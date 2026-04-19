package Hard;
import java.util.*;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//Notice that the solution set must not contain duplicate triplets.

public class _3 {
    // Brute force- O(n3)
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st= new HashSet<>();

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> temp= new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        st.add(temp);
                    }
                }
            }
        }
//        System.out.println(st);
        return new ArrayList<>(st);
    }

    // Better approach- 0(n2) but space not optimised
    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> st= new HashSet<>();

        // Using two pointers
        for(int i=0; i<nums.length; i++){
            Set<Integer> hashSet= new HashSet<>();
            for(int j=i+1; j<nums.length; j++){
                // To get arr[k]-> arr[i]+arr[j]+arr[k]= 0-> arr[k]= -(arr[i]+arr[j]);
                int k= -(nums[i]+nums[j]);
                if(hashSet.contains(k)){
                    List<Integer> temp= new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(k);
                    Collections.sort(temp);
                    st.add(temp);
                }
                hashSet.add(nums[j]);
            }
        }
        return new ArrayList<>(st);
    }

    // Optimal approach-O(n2) and space optimized
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> triplets= new ArrayList<>();

        // 2 Pointers + sorting -> no use of extra space complexity that is set.
        Arrays.sort(nums);

        int itemp=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            // to remove duplicates of i
            if(i>0 && nums[i]== nums[i-1]) continue;

            int j=i+1;
            int k=nums.length-1;

            while(j<k){
                int sum= nums[i]+nums[j]+nums[k];
                if(sum<0){
                    // To remove j duplicate values
                    int jtemp= nums[j];
                    j++;
                    while(nums[j]==jtemp && j<k){
                        j++;
                    }
                } else if(sum>0){
                    // to remove k duplicate values
                    int ktemp= nums[k];
                    k--;
                    while(nums[k]==ktemp && k>j){
                        k--;
                    }
                } else {
                    List<Integer> lt= new ArrayList<>();
                    lt.add(nums[i]);
                    lt.add(nums[j]);
                    lt.add(nums[k]);
                    triplets.add(lt);

                    // To remove duplicate values

                    int jtemp= nums[j];
                    j++;
                    // need to check boundary
                    while(nums[j]==jtemp && j<k){
                        j++;
                    }
                    int ktemp= nums[k];
                    k--;
                    while(nums[k]==ktemp && k>j){
                        k--;
                    }
                }
            }
        }

        return triplets;
    }

    static void main(String[] args) {
        List<List<Integer>> ans= threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(ans);
    }
}
