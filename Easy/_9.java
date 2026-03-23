package Easy;

//Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. The elements in the union must be in ascending order.
//The union of two arrays is an array where all values are distinct and are present in either the first array, the second array, or both.
//
//Example 1
//Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
//Output: [1, 2, 3, 4, 5, 7]
//Explanation:
//The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2

import java.util.*;

public class _9 {
    public static int[] unionArray(int[] nums1, int[] nums2) {
        Set<Integer> st= new TreeSet<>();
        for (int i=0; i<nums1.length; i++){
            st.add(nums1[i]);
        }
        for (int i=0; i<nums2.length; i++){
            st.add(nums2[i]);
        }

        int [] unionArr= new int[st.size()];
        int i=0;
        for(var it: st){
            unionArr[i]= it;
            i++;
        }

        // This approach take O(nlogn)
        return unionArr;
    }

    // MoreOptimal
    static int[] unionArrayOptimal(int[] nums1, int[] nums2){
        int i=0;
        int j=0;
        List<Integer> list= new ArrayList<>();

        if(nums1[0]<=nums2[0]){
            list.add(nums1[0]);
            i++;
        } else {
            list.add(nums2[0]);
            j++;
        }

        while(i< nums1.length && j< nums2.length){
            if (nums1[i]<=nums2[j]) {
                if(list.get(list.size()-1)!=nums1[i]){
                    list.add(nums1[i]);
                }
                i++;
            } else {
                if(list.get(list.size()-1)!=nums2[j]){
                    list.add(nums2[j]);
                }
                j++;
            }
        }

        while(i< nums1.length){
            if(list.get(list.size()-1)!=nums1[i]){
                list.add(nums1[i]);
            }
            i++;
        }

        while(j< nums2.length){
            if(list.get(list.size()-1)!=nums2[j]){
                list.add(nums2[j]);
            }
            j++;
        }

        i=0;
        int[] union= new int[list.size()];
        for (var it: list){
            union[i]= it;
            i++;
        }

        return union;
    }

    static void main(String[] args) {
        int[] union= unionArray(new int[]{3, 4, 6, 7, 9, 9}, new int[]{1, 5, 7, 8, 8});
        System.out.println(Arrays.toString(union));
    }
}
