package BasicAlgorithm.MergeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: Merge Sort
 * @author: anyj1024
 * @date: 2023/9/30
 */
public class AcWing787MergeSort {
    static int[] temp = new int[100000 + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        mergeSort(nums, 0, n - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int i = 0, j = left, k = mid + 1;
        while (j <= mid && k <= right) {
            if (nums[j] <= nums[k]) {
                temp[i++] = nums[j++];
            } else {
                temp[i++] = nums[k++];
            }
        }
        while (j <= mid) {
            temp[i++] = nums[j++];
        }
        while (k <= right) {
            temp[i++] = nums[k++];
        }
        for (i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }
}
