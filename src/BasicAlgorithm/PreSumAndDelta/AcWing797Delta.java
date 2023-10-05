package BasicAlgorithm.PreSumAndDelta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: Delta
 * @author: anyj1024
 * @date: 2023/10/5
 */
public class AcWing797Delta {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        String[] ss = br.readLine().split(" ");
        int[] nums = new int[n];
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int[] delta = new int[n + 1];
        delta[0] = nums[0];
        for (int i = 1; i < n; i++) {
            delta[i] = nums[i] - nums[i - 1];
        }
        while (m-- > 0) {
            String[] sss = br.readLine().split(" ");
            int left = Integer.parseInt(sss[0]), right = Integer.parseInt(sss[1]);
            int value = Integer.parseInt(sss[2]);
            delta[left - 1] += value;
            delta[right] -= value;
        }
        for (int i = 0; i < n; i++) {
            preSum += delta[i];
            nums[i] = preSum;
            System.out.print(nums[i] + " ");
        }
    }
}
