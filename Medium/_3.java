package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _3 {
    // Brute- two loops. iterate over each elmt check count > N/2
    // Better Approact- use HashMap.
    public static int majorityElementHashMap(int[] nums) {
        Map<Integer, Integer> hm= new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])){
                // int count= hm.get(nums[i])++;
                hm.put(nums[i], hm.get(nums[i])+1);
            } else {
                hm.put(nums[i], 1);
            }
        }

        int max=Integer.MIN_VALUE;
        int result= 0;
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            if(entry.getValue()>max) {
                max= entry.getValue();
                result= entry.getKey();
            }
        }
        return result;
    }

    // More better and simple approach- sorting. only if majority element oes exist.
    public int majorityElementSorting(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // Movers or moores voting algorithm
    public static int majorityElementOptimal(int[] nums) {
        int count=0;
        int elmt= nums[0];
        for(int i=0; i<nums.length; i++){
            if(count==0){
                count= 1;
                elmt= nums[i];
            }
            else if(elmt== nums[i]){
                count++;
            } else {
                count--;
            }
        }
        count=0;
        for(int i=0; i<nums.length; i++){
            if(elmt== nums[i]) count++;
        }
        return (count>=nums.length/2) ? elmt: -1;
    }

    static void main(String[] args) {
        int result= majorityElementOptimal(new int[]{2,2,1,1,1,2,2});
        System.out.println(result);
    }
}
