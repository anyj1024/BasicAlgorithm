package BasicAlgorithm.PreSumAndDelta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: Delta Matrix
 * @author: anyj1024
 * @date: 2023/10/5
 */
public class AcWing798DeltaMatrix {
    static int[][] delta = new int[1010][1010];
    static int[][] matrix = new int[1010][1010];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int m = Integer.parseInt(s1[0]), n = Integer.parseInt(s1[1]), k = Integer.parseInt(s1[2]);
        for (int i = 1; i <= m; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = Integer.parseInt(s[j - 1]);
                delta[i][j] += matrix[i][j];
                delta[i + 1][j] -= matrix[i][j];
                delta[i][j + 1] -= matrix[i][j];
                delta[i + 1][j + 1] += matrix[i][j];
            }
        }
        while (k-- > 0) {
            String[] s2 = br.readLine().split(" ");
            int x1 = Integer.parseInt(s2[0]), y1 = Integer.parseInt(s2[1]);
            int x2 = Integer.parseInt(s2[2]), y2 = Integer.parseInt(s2[3]);
            int value = Integer.parseInt(s2[4]);
            delta[x1][y1] += value;
            delta[x2 + 1][y1] -= value;
            delta[x1][y2 + 1] -= value;
            delta[x2 + 1][y2 + 1] += value;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j] - matrix[i - 1][j - 1] + delta[i][j];
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}