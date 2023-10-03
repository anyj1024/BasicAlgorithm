package BasicAlgorithm.HighPrecision;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description: High Precision Multiplication
 * @author: anyj1024
 * @date: 2023/10/3
 */
public class AcWing793HighPrecisionMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), s1 = sc.next();
        List<Integer> nums = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0; i--) nums.add(s.charAt(i) - '0');
        List<Integer> ans = multi(nums, Integer.parseInt(s1));
        for (int i = ans.size() - 1; i >= 0; i--) {
            System.out.print(ans.get(i));
        }
    }

    private static List<Integer> multi(List<Integer> nums, int num) {
        List<Integer> ans = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < nums.size() || temp != 0; i++) {
            if (i < nums.size()) {
                temp += nums.get(i) * num;
            }
            ans.add(temp % 10);
            temp /= 10;
        }
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) {
            ans.remove(ans.size() - 1);
        }
        return ans;
    }
}
