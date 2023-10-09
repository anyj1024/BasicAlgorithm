package DataStructure.KMP;

import java.io.*;

/**
 * @description: KMP String
 * @author: anyj1024
 * @date: 2023/10/9
 */
public class AcWing831KMPString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = 100010, M = 1000010;
        int n = Integer.parseInt(br.readLine());
        String p = br.readLine();
        char[] ps = new char[N];
        for (int i = 1; i <= n; i++) ps[i] = p.charAt(i - 1);
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] ss = new char[M];
        for (int i = 1; i <= m; i++) ss[i] = s.charAt(i - 1);
        int[] next = new int[N];
        for (int i = 2, j = 0; i <= n; i++) {
            while (j > 0 && ps[i] != ps[j + 1]) j = next[j];
            if (ps[i] == ps[j + 1]) j++;
            next[i] = j;
        }

        for (int i = 1, j = 0; i <= m; i++) {
            while (j > 0 && ss[i] != ps[j + 1]) j = next[j];
            if (ss[i] == ps[j + 1]) j++;
            if (j == n) {
                bw.write((i - n) + " ");
                j = next[j];
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
