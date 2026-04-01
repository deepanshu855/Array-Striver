package Medium;
import java.util.*;

//Given an integer array nums, return a list of all the leaders in the array.
//A leader in an array is an element whose value is strictly greater than all elements to its right in the given array. The rightmost element is always a leader. The elements in the leader array must appear in the order they appear in the nums array.

public class _9 {
    public static List<Integer> leaders(int[] nums) {
        int n= nums.length;
        int max= nums[n-1];
        List<Integer> result= new ArrayList<>();
        for(int i=n-1; i>=0; i--){
            if(nums[i]>=max) {
                result.add(0, nums[i]);
            }
            max= Math.max(max, nums[i]);
        }
        return result;
    }

    static void main(String[] args) {
//        List<Integer> result= new ArrayList<>(Arrays.asList(10, 22, 12, 3, 0, 6));
        List<Integer> result= leaders(new int[]{10, 22, 12, 3, 0, 6});
        System.out.println(result);
    }
}
