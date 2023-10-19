package SearchAndGraphTheory.DFS;

import java.util.Scanner;

/**
 * @description: N Queen
 * @author: anyj1024
 * @date: 2023/10/19
 */
public class AcWing843NQueen {
    static Scanner in = new Scanner(System.in);
    static int N = 20;
    static boolean[] col = new boolean[N], dg = new boolean[N], udg = new boolean[N];
    static char[][] chs = new char[N][N];
    static int n = 0;

    static void dfs(int u)
    {
        if (u == n)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    System.out.print(chs[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++)
        {
            if (!col[i] && !dg[i - u + n] && !udg[i + u])
            {
                chs[u][i] = 'Q';
                col[i] = dg[i - u + n] = udg[i + u] = true;
                dfs(u + 1);
                col[i] = dg[i - u + n] = udg[i + u] = false;
                chs[u][i] = '.';
            }
        }

    }

    public static void main(String[] args)
    {
        n = in.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) chs[i][j] = '.';
        dfs(0);
    }

}
