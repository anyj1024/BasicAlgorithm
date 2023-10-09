package DataStructure.MonotonicQueue;

import java.io.*;

/**
 * @description: Sliding Window
 * @author: anyj1024
 * @date: 2023/10/9
 */
public class AcWing154SlidingWindow {
    static int N = 1000010;
    static int n, k;
    static int head, tail;
    static int[] q = new int[N];
    static int[] nums = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        k = Integer.parseInt(s1[1]);
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(s2[i]);

        head = 0;
        tail = -1;
        for (int i = 0; i < n; i++) {
            if (head <= tail && q[head] < i - k + 1) head++;
            while (head <= tail && nums[q[tail]] >= nums[i]) tail--;
            q[++tail] = i;
            if (i >= k - 1) pw.print(nums[q[head]] + " ");
        }
        pw.println();
        head = 0;
        tail = -1;
        for (int i = 0; i < n; i++) {
            if (head <= tail && q[head] < i - k + 1) head++;
            while (head <= tail && nums[q[tail]] <= nums[i]) tail--;
            q[++tail] = i;
            if (i >= k - 1) pw.print(nums[q[head]] + " ");
        }
        pw.flush();
    }
}
