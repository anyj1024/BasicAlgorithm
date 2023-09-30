package BasicAlgorithm.QuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @description: The Kth Largest Number Of Array
 * @author: anyj1024
 * @date: 2023/9/30
 */
public class AcWing786TheKthNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]), k = Integer.parseInt(s1[1]);
        String[] ss = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        quickSort(nums, 0, n - 1);
        System.out.println(nums[k - 1]);
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot);
            quickSort(nums, pivot + 1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        Random random = new Random();
        int rIdx = random.nextInt(right - left + 1) + left;
        swap(nums, rIdx, right);
        int idx = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < nums[right]) {
                swap(nums, i, idx++);
            }
        }
        swap(nums, idx, right);
        return idx;
    }

    private static void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}
