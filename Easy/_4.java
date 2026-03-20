package Easy;

// Remove duplicates from sorted arrays.

public class _4 {
    public static int removeDuplicates(int[] nums) {
        int j= 1;
        int k=0;
        int curr = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]== curr){}
            else{
                curr= nums[i];
                nums[j]= curr;
                j++;
                k++;
            }
        }

        for(int i=0; i<=k; i++){
            System.out.print(nums[i]+ " ");
        }
        return k;
    }

    static void main(String[] args) {
        int[] arr= {0,0,1,1,1,2,2,3,3,4};
        int k= removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
}
