package BasicAlgorithm.TwoPointerAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: Longest Consecutive Non-repeating Subsequence
 * @author: anyj1024
 * @date: 2023/10/5
 */
public class Acwing799LongestConsecUniSubseq {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ss = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0;
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.get(nums[right]) > 1) {
                if (map.get(nums[left]) >= 1) {
                    map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        System.out.println(ans);
    }
}
