package BasicAlgorithm.IntervalMerge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: Interval Merge
 * @author: anyj1024
 * @date: 2023/10/5
 */
public class AcWing803IntervalMerge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] intervals = new int[n][2];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            intervals[i][0] = Integer.parseInt(s[0]);
            intervals[i][1] = Integer.parseInt(s[1]);
        }
        Arrays.sort(intervals, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
        list.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < n; i++) {
            if (list.get(list.size() - 1)[1] < intervals[i][0]) {
                list.add(intervals[i]);
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
            }
        }
        System.out.println(list.size());
    }
}
