package SearchAndGraphTheory.DFS;

import java.util.*;
import java.io.*;

/**
 * @description: Number Permutation
 * @author: anyj1024
 * @date: 2023/10/18
 */
public class AcWing842NumberPermutation {
    private static final int N = 10;
    private static int[] path = new int[N];
    private static boolean[] st = new boolean[N];
    public static void dfs(int u, int n){
        if(u == n){
            for(int i = 0; i < n; i++){
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= n; i++){
            if(!st[i]){
                path[u] = i;
                st[i] = true;
                dfs(u + 1, n);
                st[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        dfs(0,n);
    }
}