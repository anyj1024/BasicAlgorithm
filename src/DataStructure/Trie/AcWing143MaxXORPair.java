package DataStructure.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: Maximum XOR Pair
 * @author: anyj1024
 * @date: 2023/10/11
 */
public class AcWing143MaxXORPair {

    static int[][] son = new int[3000000][2];
    static int idx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s1[i]);
            insert(nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, search(nums[i]));
        }
        System.out.println(ans);
        br.close();
    }

    private static void insert(int x) {
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            if (son[p][x >> i & 1] == 0) {
                son[p][x >> i & 1] = ++idx;
            }
            p = son[p][x >> i & 1];
        }
    }

    private static int search(int x) {
        int p = 0, ans = 0;
        for (int i = 30; i >= 0; i--) {
            int s = x >> i & 1;
            int sp = s == 0 ? 1 : 0;
            if (son[p][sp] != 0) {
                ans += 1 << i;
                p = son[p][sp];
            } else {
                p = son[p][s];
            }
        }
        return ans;
    }
}
