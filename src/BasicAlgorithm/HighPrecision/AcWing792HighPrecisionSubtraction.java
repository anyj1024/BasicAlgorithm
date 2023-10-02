package BasicAlgorithm.HighPrecision;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description: High Precision Subtraction
 * @author: anyj1024
 * @date: 2023/10/2
 */
public class AcWing792HighPrecisionSubtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next(), s2 = sc.next();
        List<Integer> n1 = new ArrayList<>(), n2 = new ArrayList<>();
        for (int i = s1.length() - 1; i >= 0; i--) n1.add(s1.charAt(i) - '0');
        for (int i = s2.length() - 1; i >= 0; i--) n2.add(s2.charAt(i) - '0');
        List<Integer> ans = subtraction(n1, n2);
        for (int i = ans.size() - 1; i >= 0; i--) {
            System.out.print(ans.get(i));
        }
    }

    private static List<Integer> subtraction(List<Integer> n1, List<Integer> n2) {
        if (!compare(n1, n2)) {
            System.out.print("-");
            return subtraction(n2, n1);
        }
        List<Integer> ans = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < n1.size(); i++) {
            temp = n1.get(i) - temp;
            if (i < n2.size()) {
                temp -= n2.get(i);
            }
            ans.add((temp + 10) % 10);
            if (temp < 0) temp = 1;
            else temp = 0;
        }
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) {
            ans.remove(ans.size() - 1);
        }
        return ans;
    }

    private static boolean compare(List<Integer> num1, List<Integer> num2) {
        if (num1.size() != num2.size()) return num1.size() > num2.size();
        for (int i = num1.size() - 1; i >= 0; i--) {
            if (num1.get(i) != num2.get(i)) {
                return num1.get(i) > num2.get(i);
            }
        }
        return true;
    }
}
