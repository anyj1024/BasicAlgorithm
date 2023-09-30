package BasicAlgorithm.MergeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: The Count Of Intervals
 * @author: anyj1024
 * @date: 2023/9/30
 */
public class AcWing788CountOfIntervals {
    static int[] temp = new int[100000 + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }
        System.out.println(getCountOfIntervals(nums, 0, n - 1));
    }

    private static long getCountOfIntervals(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) >> 1;
        int i = 0, j = left, k = mid + 1;
        long ans = getCountOfIntervals(nums, left, mid) + getCountOfIntervals(nums, mid + 1, right);
        while (j <= mid && k <= right) {
            if (nums[j] <= nums[k]) {
                temp[i++] = nums[j++];
            } else {
                ans += mid - j + 1;
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
        return ans;
    }
}
