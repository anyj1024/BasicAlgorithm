package BasicAlgorithm.Discretization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @description: Range Sum
 * @author: anyj1024
 * @date: 2023/10/5
 */
public class AcWing802RangeSum {
    static int[] nums = new int[300010];
    static int[] preSum = new int[300010];
    static List<Integer> all = new ArrayList<>();
    static class Pair {
        int x1, x2;
        public Pair(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    static int find(int x) {
        int left = 0, right = all.size() - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (all.get(mid) <= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int m = Integer.parseInt(s1[0]), n = Integer.parseInt(s1[1]);
        List<Pair> add = new ArrayList<>(), query = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] s2 = br.readLine().split(" ");
            int x1 = Integer.parseInt(s2[0]), x2 = Integer.parseInt(s2[1]);
            add.add(new Pair(x1, x2));
            all.add(x1);
        }
        for (int i = 0; i < n; i++) {
            String[] s3 = br.readLine().split(" ");
            int x1 = Integer.parseInt(s3[0]), x2 = Integer.parseInt(s3[1]);
            query.add(new Pair(x1, x2));
            all.add(x1);
            all.add(x2);
        }
        all = new ArrayList<>(new HashSet<>(all));
        Collections.sort(all);
        for (int i = 0; i < m; i++) {
            int x = find(add.get(i).x1);
            nums[x] += add.get(i).x2;
        }
        for (int i = 1; i < 300010; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            int left = find(query.get(i).x1);
            int right = find(query.get(i).x2);
            System.out.println(preSum[right] - preSum[left - 1]);
        }
    }
}
