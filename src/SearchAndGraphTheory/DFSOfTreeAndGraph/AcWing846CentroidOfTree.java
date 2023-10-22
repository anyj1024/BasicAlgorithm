package SearchAndGraphTheory.DFSOfTreeAndGraph;

import java.util.Scanner;

/**
 * @description: Centroid Of A Tree
 * @author: anyj1024
 * @date: 2023/10/22
 */
public class AcWing846CentroidOfTree {
    static int N = 100010,M = N * 2,idx,n;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static boolean[] st = new boolean[N];
    static int ans = N;
    public static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    public static int dfs(int u){
        int res = 0;
        st[u] = true;
        int sum = 1;

        for(int i = h[u];i != -1 ; i = ne[i]){
            int j = e[i];
            if(!st[j]){
                int s = dfs(j);
                res = Math.max(res,s);
                sum += s;
            }
        }
        res = Math.max(res,n-sum);
        ans = Math.min(res,ans);
        return sum;
    }
    public static void main(String[] ags){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 1 ; i < N ; i++ ){
            h[i] = -1;
        }
        for(int i = 0 ; i < n - 1 ; i ++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            add(a,b);
            add(b,a);
        }
        dfs(1);
        System.out.println(ans);
    }
}