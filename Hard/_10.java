package Hard;
import java.util.Arrays;

//Count Inversions

public class _10 {

    // This is solved using merge sort and applying algorithm during merge.

    // Function to divide the array recursively
    public static int mergeSort(int[] arr, int low, int high) {
        int cnt=0;
        // Base case: single element is already sorted
        if (low >= high) {
            return cnt;
        }

        // Find the middle index
        int mid = low + (high - low) / 2;
        // Sort left half
        cnt+=mergeSort(arr, low, mid);
        // Sort right half
        cnt+=mergeSort(arr, mid + 1, high);
        // Merge the two sorted halves
        cnt+=merge(arr, low, mid, high);

        return cnt;
    }

    // Function to merge two sorted halves
    public static int merge(int[] arr, int low, int mid, int high) {

        // Temporary array to store merged elements
        int[] temp = new int[high - low + 1];

        int left = low;      // Pointer for left half
        int right = mid + 1; // Pointer for right half
        int k = 0;           // Pointer for temp array

        // Compare elements from both halves
        int cnt=0;
        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                cnt+=(mid-left+1);
                temp[k++] = arr[right++];
            }
        }

        // Copy remaining elements from left half
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // Copy remaining elements from right half
        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // Copy merged elements back to original array
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }

        return cnt;
    }

    static void main(String[] args) {
        int[] arr = {5,3,2,4,1};
        int cnt= mergeSort(arr, 0, arr.length - 1);
        System.out.println(cnt);
    }
}