package Medium;

//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
//You must do it in place.

import java.util.Arrays;

public class _11 {
    // Brute force. -> only for positive or array doesn't contain Integer.MAX and MIN values
    public static void setZeroesBrute(int[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    markRow(matrix, i, n);
                    markCol(matrix, j, m);
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==Integer.MAX_VALUE){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void markRow(int[][] nums, int i, int n){
        for(int j=0; j<n; j++){
            if(nums[i][j]!=0){
                nums[i][j]=Integer.MAX_VALUE;
            }
        }
    }

    public static void markCol(int[][] nums, int j, int m){
        for(int i=0; i<m; i++){
            if(nums[i][j]!=0){
                nums[i][j]= Integer.MAX_VALUE;
            }
        }
    }

    // Better approach- useing marker array but the space complexity is still not optimal.
    public static void setZeroesBetter(int[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        int[] row= new int[m]; // Extra row initialized with 0.
        int[] col= new int[n]; // Extra col initialized with 0.

        // Make the extra row and col 1 if matrix[i][j] is 0.
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        // if the row and col is 1 make the arr[i][j] 0.
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(row[i]==1 || col[j]== 1){
                    matrix[i][j]=0;
                }
            }
        }
    }

    // Optimal i.e O(1) space complexity
    public static void setZeroesOptimal(int[][] matrix) {
        // Using O(1). space approach.
        int m= matrix.length;
        int n= matrix[0].length;

        // Now these first and first col will be used to mark. they are the marker array.
        // col[n]-> matrix[0][..]
        // row[m]-> matrix[..]][0]
        int col=1; // since a[0][0] is the colliding index.

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    // mark the ith row
                    matrix[i][0]=0;
                    if(j!=0){
                        // mark the jth col
                        matrix[0][j]=0;
                    } else {
                        col=0;
                    }
                }
            }
        }

        // Now we'll change the value but we do not change markers value. hence we do need to iterate the 0 index.
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j]!=0){
                    if(matrix[i][0]==0 || matrix[0][j]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }

        // Key step we need to first check for the matrix[0][0] because if it change first it impacts the matrix. as the first row last col value is affected
        if(matrix[0][0]==0){
            for(int j=0; j<n; j++){
                matrix[0][j]=0;
            }
        }

        if(col==0){
            for(int i=0; i<m; i++){
                matrix[i][0]=0;
            }
        }
    }

    static void main(String[] args) {
        int[][] matrix= {{1,1,1},{1,0,1},{1,1,1}};
        setZeroesOptimal(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
