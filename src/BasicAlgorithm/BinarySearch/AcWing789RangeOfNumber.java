package BasicAlgorithm.BinarySearch;

import javax.sql.rowset.spi.SyncResolver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: The Range Of Number In Array
 * @author: anyj1024
 * @date: 2023/9/30
 */
public class AcWing789RangeOfNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" "), s2 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]), q = Integer.parseInt(s1[1]);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(s2[i]);
        while (q-- > 0) {
            int val = Integer.parseInt(br.readLine());
            int left = binarySearch(nums, val);
            int right = binarySearch(nums, val + 1) - 1;
            if (left >= n || nums[left] != val) {
                System.out.println("-1 -1");
            } else {
                System.out.println(left + " " + right);
            }
        }
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
