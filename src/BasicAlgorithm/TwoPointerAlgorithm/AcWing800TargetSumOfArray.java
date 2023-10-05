package BasicAlgorithm.TwoPointerAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: The Target Sum Of Array Element
 * @author: anyj1024
 * @date: 2023/10/5
 */
public class AcWing800TargetSumOfArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int m = Integer.parseInt(ss[0]), n = Integer.parseInt(ss[1]), val = Integer.parseInt(ss[2]);
        int[] nums1 = new int[m];
        int[] nums2 = new int[n];
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        br.close();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            nums1[i] = Integer.parseInt(s1[i]);
            map.put(nums1[i], i);
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = Integer.parseInt(s2[i]);
            if (map.containsKey(val - nums2[i])) {
                System.out.println(map.get(val - nums2[i]) + " " + i);
            }
        }
    }
}
