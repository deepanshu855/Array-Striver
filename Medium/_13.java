package Medium;
import java.util.*;

//Given an m x n matrix, return all elements of the matrix in spiral order.

public class _13 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral= new ArrayList<>();

        int m=matrix.length;
        int n=matrix[0].length;

        int left=0;
        int right=n-1; // 3

        int top=0;
        int bottom=m-1; // 3

        while(top<=bottom && left<=right){
            // Left-> Right
            for(int i=left; i<=right; i++){ // 1
                spiral.add(matrix[top][i]);
            }
            top++;

            if(top>bottom) {
                break;
            }

            // Top-> Bottom
            for(int i=top; i<=bottom; i++){ // 2 3
                spiral.add(matrix[i][right]);
            }
            right--;

            // Right-> Left
            for(int i=right; i>=left; i--){ // 2
                spiral.add(matrix[bottom][i]);
            }
            bottom--;

            if(left> right) break;

            // Bottom-> Top
            for(int i=bottom; i>=top; i--){
                spiral.add(matrix[i][left]);
            }
            left++;
        }

        return spiral;
    }

    static void main(String[] args) {
        int [][] matrix= {{1,2,3}, {4,5,6}, {7,8,9}};
        List<Integer> lt= spiralOrder(matrix);
        System.out.println(lt); //[1,2,3,6,9,8,7,4,5]
    }
}
