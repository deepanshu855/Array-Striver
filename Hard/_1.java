package Hard;

// PASCAL'S TRIANGLE.
// FOR PASCAL'S TRIANGLE USE FORMULA: r-1 C c-1 (r= row c= column)

import java.util.*;

public class _1 {
    // PART1: GIVEN R&C TELL THE ELEMENT AT THAT PLACE.
    public static int nCr(int rowNum, int colNum){
        // To find element at given r&c we have combination formula.
        int ans=1;
        int r= rowNum-1;
        int c= colNum-1;

        for(int i=0; i<c; i++){
         ans= ans*(r-i);
         ans= ans/(i+1);
        }

        return ans;
    }

    //PART2: PRINT ANY NTH ROW OF PASCAL TRIANGLE
    public static List<Integer> generateRow(int n){
        // Brute force will be to find r-1 C c-1 (combination) of each element. TC=0(NXN)
//        for(int i=1; i<=n; i++){
//            int ans= nCr(n,i);
//            System.out.print(ans+ " ");
//        }

        List<Integer> temp= new ArrayList<>();
        // OPTIMAL WE CAN DERIVE THE FORMULA BY OBSERVING EVERY ROW OF THE TRIANGLE: ans*(row-i)/i;
        int ans=1;
        temp.add(ans);
        for(int i=1; i<n; i++){
            ans= (ans*(n-i))/i;
            temp.add(ans);
        }
        return temp;
    }

    // PART3: GIVEN N PRINT THE ENTIRE TRIANGLE.
    public static List<List<Integer>> pascalTriangle3(int n){
        // Brute force will be to generate the every element of the pascal triangle using the combination formula. firsl loop for row and second for col and the find nCr.

        // Optimal: Use the approach to generate single row. instead of single row generate n rows.
        List<List<Integer>> ansList= new ArrayList<>();
        for(int i=1; i<=n; i++){
            List<Integer> temp= generateRow(i);
            ansList.add(temp);
        }

        return ansList;
    }

    public static void main(String[] args) {
        int result= nCr(5,3);
//        System.out.println(result);
        List<List<Integer>> ans= pascalTriangle3(5);
        System.out.println(ans);
    }
}
