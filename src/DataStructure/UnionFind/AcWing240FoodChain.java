package DataStructure.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: Food Chain
 * @author: anyj1024
 * @date: 2023/10/14
 */
public class AcWing240FoodChain {
    static int N = 50010;
    static int n, m;
    static int[] p = new int[N];
    static int[] d = new int[N];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args ) throws IOException {
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        for(int i = 0; i < n; i ++ ) p[i] = i;
        int res = 0;
        while(m -- > 0)
        {
            String[] strs = br.readLine().split(" ");
            int t = Integer.parseInt(strs[0]);
            int x = Integer.parseInt(strs[1]);
            int y = Integer.parseInt(strs[2]);
            if(x > n || y > n) res ++;
            else
            {
                int px = find(x), py = find(y);
                if(t == 1)
                {
                    if(px == py && (d[x] - d[y]) % 3 != 0) res ++;
                    else if(px != py) {
                        p[px] = py;
                        d[px] = d[y] - d[x];
                    }
                }
                else
                {
                    if(px == py && (d[x] - d[y] - 1) % 3 != 0) res ++;
                    else if(px != py)
                    {
                        p[px] = py;
                        d[px] = d[y] + 1 - d[x];
                    }
                }
            }
        }
        System.out.println(res);
    }
    static int find(int x)
    {
        if(p[x] != x)
        {
            int t = find(p[x]);
            d[x] += d[p[x]];
            p[x] = t;
        }
        return p[x];
    }
}
