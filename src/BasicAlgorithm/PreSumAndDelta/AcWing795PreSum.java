package BasicAlgorithm.PreSumAndDelta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: Prefix Sum
 * @author: anyj1024
 * @date: 2023/10/3
 */
public class AcWing795PreSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        int[] nums = new int[n];
        String[] num = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(num[i]);
            if (i != 0) {
                nums[i] += nums[i - 1];
            }
        }
        while (m-- > 0) {
            String[] ss = br.readLine().split(" ");
            int left = Integer.parseInt(ss[0]), right = Integer.parseInt(ss[1]);
            if (left == 1) System.out.println(nums[right - 1]);
            else System.out.println(nums[right - 1] - nums[left - 2]);
        }
    }
}
