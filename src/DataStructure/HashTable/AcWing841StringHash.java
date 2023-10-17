package DataStructure.HashTable;

import java.io.*;

/**
 * @description: String Hash
 * @author: anyj1024
 * @date: 2023/10/17
 */
public class AcWing841StringHash {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static final int N = 100010, P = 131;

    static final long Q = Long.MAX_VALUE;
    static long[] h = new long[N];
    static long[] p = new long[N];
    static char[] c = new char[N];

    public static void main(String[] args) throws IOException {
        String[] s1 = bf.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        c = (" " + bf.readLine()).toCharArray();
        h[0] = 0;
        p[0] = 1;
        for(int i = 1; i <= n; i++) {
            p[i] = (p[i - 1] * P) % Q;
            h[i] = (h[i - 1] * P + c[i]) % Q;
        }

        while(m-- > 0) {
            int l1, r1, l2, r2;
            String[] s3 = bf.readLine().split(" ");
            l1 = Integer.parseInt(s3[0]);
            r1 = Integer.parseInt(s3[1]);
            l2 = Integer.parseInt(s3[2]);
            r2 = Integer.parseInt(s3[3]);

            if(query(l1, r1) == query(l2, r2)) {
                pw.println("Yes");
            }else {
                pw.println("No");
            }
        }
        pw.flush();
    }

    public static long query(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }
}

