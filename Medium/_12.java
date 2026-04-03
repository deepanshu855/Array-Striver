package Medium;

//You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

import java.util.Arrays;

public class _12 {
    // Brute- since we are not doing inPlace
    public static void rotateBrute(int[][] matrix) {
        int n= matrix.length;
        int[][] rotate= new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                // n-j-1=> 3-0-1=2 => 3-1-1=1 => 3-2-1=0
                rotate[i][j]= matrix[n-j-1][i];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j]= rotate[i][j];
            }
        }
    }

    public static void rotateOptimal(int[][] matrix) {
        int n= matrix.length;

        for(int i=0; i<n/2; i++){
            for(int j=0; j<n; j++){
                int temp= matrix[i][j];
                matrix[i][j]= matrix[n-i-1][j];
                matrix[n-i-1][j]= temp;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i<j){
                    int temp= matrix[i][j];
                    matrix[i][j]= matrix[j][i];
                    matrix[j][i]= temp;
                }
            }
        }
    }

    static void main(String[] args) {
        int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
        rotateOptimal(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
