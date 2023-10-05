package BasicAlgorithm.BitOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: The Count Of 1 In Number
 * @author: anyj1024
 * @date: 2023/10/5
 */
public class AcWing801CountOfOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
            System.out.print(getBitCount(nums[i]) + " ");
        }
        br.close();
    }

    private static int getBitCount(int number) {
        int ans = 0;
        while (number != 0) {
            number &= number - 1;
            ans++;
        }
        return ans;
    }
}
