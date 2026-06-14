package Hard;
import java.util.*;

public class _2 {
    public static List<Integer> majorityElementBrute(int[] nums) {
        int n= nums.length;

        Map<Integer, Integer> hm= new HashMap<>();
        List<Integer> result= new ArrayList<>();

        for(int i=0; i<n; i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i],1);
            } else {
                int temp= hm.get(nums[i])+1;
                hm.put(nums[i],temp);
            }
        }

        int min= n/3+1;
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            if(entry.getValue()>=min){
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static List<Integer> majorityElement(int[] nums) {
        // Solve using moore's algo: in moore we'll traverse the complete array and cancel the element. since elements count greater than n/3. hence, there will be atmost 2 element that will not be canceled.

        int n= nums.length;
        List<Integer> result= new ArrayList<>();
        int cnt1=0; // to track the first element
        int cnt2=0; // to track the second element

        int elmt1= Integer.MIN_VALUE;
        int elmt2= Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(cnt1==0 && nums[i]!=elmt2){
                cnt1=1;
                elmt1=nums[i];
            }
            else if(cnt2==0 && nums[i]!=elmt1){
                cnt2=1;
                elmt2=nums[i];
            }
            else if(elmt1==nums[i]) cnt1++;
            else if(elmt2==nums[i]) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1=0;
        cnt2=0;
        for(int i=0; i<n; i++){
            if(nums[i]==elmt1) cnt1++;
            if(nums[i]==elmt2) cnt2++;
        }

        if(cnt1>=n/3+1) result.add(elmt1);
        if(cnt2>=n/3+1) result.add(elmt2);

        return result;
    }

    static void main(String[] args) {
        List<Integer> ans= majorityElement(new int[]{1,1,1,3,3,2,2,2,2});
        System.out.println(ans);
    }
}
