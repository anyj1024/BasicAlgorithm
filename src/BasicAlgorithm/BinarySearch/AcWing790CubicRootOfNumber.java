package BasicAlgorithm.BinarySearch;

import java.util.Scanner;

/**
 * @description: The Cubic Root Of The Number
 * @author: anyj1024
 * @date: 2023/9/30
 */
public class AcWing790CubicRootOfNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();

        double left = -10000, right = 10000;
        while (right - left > 1e-7) {
            double mid = (left + right) / 2;
            if (mid * mid * mid > number) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.printf("%.6f", left);
    }
}
