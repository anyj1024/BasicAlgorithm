package DataStructure.UnionFind;

import java.util.Scanner;

/**
 * @description: Union Of Sets
 * @author: anyj1024
 * @date: 2023/10/11
 */
public class AcWing836UnionSets {
    static int N = 100010;
    static int[] position = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 0; i < n; i++) position[i] = i;
        while (m-- > 0) {
            String s = sc.next();
            int a = sc.nextInt(), b = sc.nextInt();
            if (s.equals("M")) {
                position[find(a)] = find(b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println("Yes");
                } else
                    System.out.println("No");
            }
        }
    }

    private static int find (int x) {
        if (position[x] != x) {
            position[x] = find(position[x]);
        }
        return position[x];
    }
}
