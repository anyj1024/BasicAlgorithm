package BasicAlgorithm.HighPrecision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @description: High Precision Addition
 * @author: anyj1024
 * @date: 2023/10/1
 */
public class AcWing791HighPrecisionAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next(), s2 = sc.next();
        List<Integer> n1 = new ArrayList<>(), n2 = new ArrayList<>();
        for (int i = s1.length() - 1; i >= 0; i--) n1.add(s1.charAt(i) - '0');
        for (int i = s2.length() - 1; i >= 0; i--) n2.add(s2.charAt(i) - '0');
        List<Integer> ans = plus(n1, n2);
        for (int i = ans.size() - 1; i >= 0; i--) {
            System.out.print(ans.get(i));
        }
    }

    private static List<Integer> plus(List<Integer> n1, List<Integer> n2) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        int carry = 0;
        while (i < n1.size() || j < n2.size()) {
            int num1 = i < n1.size() ? n1.get(i++) : 0;
            int num2 = j < n2.size() ? n2.get(j++) : 0;
            int sum = num1 + num2 + carry;
            ans.add(sum % 10);
            carry = sum / 10;
        }
        while (carry != 0) {
            ans.add(carry % 10);
            carry /= 10;
        }
        return ans;
    }
}
