package Hard;
// Reverse Pairs

public class _11 {
    // Brute force
    public static int reversePairsBrute(int[] nums) {
        int cnt=0;

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]>2*nums[j]) cnt++;
            }
        }

        return cnt;
    }

    // Optimal approach using MergeSort
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
        // We'll perform the operation before merge.
        cnt+=countPairs(arr,low,mid,high);
        // Merge the two sorted halves
        merge(arr, low, mid, high);
        return cnt;
    }

    public static int countPairs(int[] arr, int low, int mid, int high){
        int cnt=0;
        int right=mid+1;
        for(int i=low; i<=mid; i++){
            while(right<=high && arr[i]>2L*arr[right]) {
                right++;
            }
            cnt+=(right-(mid+1));
        }
        return cnt;
    }

    // Function to merge two sorted halves
    public static void merge(int[] arr, int low, int mid, int high) {
        // Temporary array to store merged elements
        int[] temp = new int[high - low + 1];

        int left = low;      // Pointer for left half
        int right = mid + 1; // Pointer for right half
        int k = 0;           // Pointer for temp array

        // Compare elements from both halves
        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
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
    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    static void main(String[] args) {
        int cnt= reversePairs(new int[]{2,4,3,5,1});
        System.out.println(cnt);
    }
}
