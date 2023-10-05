package BasicAlgorithm.PreSumAndDelta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: The Sum Of Sub Matrix
 * @author: anyj1024
 * @date: 2023/10/5
 */
public class AcWing796SumOfSubMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int row = Integer.parseInt(s[0]), col = Integer.parseInt(s[1]), n = Integer.parseInt(s[2]);
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(s1[j]);
            }
        }

        int[][] preSum = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                preSum[i][j] = matrix[i - 1][j - 1] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            String[] s2 = br.readLine().split(" ");
            int r1 = Integer.parseInt(s2[0]), c1 = Integer.parseInt(s2[1]);
            int r2 = Integer.parseInt(s2[2]), c2 = Integer.parseInt(s2[3]);
            System.out.println(preSum[r2][c2] - preSum[r1 - 1][c2] - preSum[r2][c1 - 1] + preSum[r1 - 1][c1 - 1]);
        }
    }
}
