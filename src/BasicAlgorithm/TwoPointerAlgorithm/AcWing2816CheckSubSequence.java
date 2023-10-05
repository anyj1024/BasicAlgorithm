package BasicAlgorithm.TwoPointerAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: Check Sub Sequence
 * @author: anyj1024
 * @date: 2023/10/5
 */
public class AcWing2816CheckSubSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]), n = Integer.parseInt(s[1]);
        int[] nums1 = new int[m], nums2 = new int[n];
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) nums1[i] = Integer.parseInt(s1[i]);
        for (int i = 0; i < n; i++) nums2[i] = Integer.parseInt(s2[i]);
        br.close();

        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (idx == m) break;
            if (nums2[i] == nums1[idx]) {
                idx++;
            }
        }
        if (idx == m) System.out.println("Yes");
        else System.out.println("No");
    }
}
