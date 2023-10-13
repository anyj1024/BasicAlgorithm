package DataStructure.UnionFind;

import java.util.Scanner;

/**
 * @description: Number Of Vertices In A Connected Component
 * @author: anyj1024
 * @date: 2023/10/13
 */
public class AcWing837NumberOfVerticesInConnectedComponent {
    static int N = 100010;
    static int[] p = new int[N];
    static int[] size = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            p[i] = i;
            size[i] = 1;
        }
        while (m-- > 0) {
            String s = sc.next();
            if (s.equals("C")) {
                int a = sc.nextInt(), b = sc.nextInt();
                if (find(a) == find(b)) continue;
                else {
                    size[find(b)] += size[find(a)];
                    p[find(a)] = find(b);
                }
            } else if(s.equals("Q1")){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(find(a) == find(b))System.out.println("Yes");
            else System.out.println("No");
        }else{
            int a = sc.nextInt();
            System.out.println(size[find(a)]);
        }
        }
    }

    public static int find(int x){
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

}
