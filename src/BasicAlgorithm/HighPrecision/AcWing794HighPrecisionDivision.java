package BasicAlgorithm.HighPrecision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @description: High Precision Division
 * @author: anyj1024
 * @date: 2023/10/3
 */
public class AcWing794HighPrecisionDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), s1 = sc.next();
        List<Integer> nums = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0; i--) nums.add(s.charAt(i) - '0');
        List<Integer> ans = div(nums, Integer.parseInt(s1));
        for (int i = 0; i < ans.size() - 1; i++) {
            System.out.print(ans.get(i));
        }
        System.out.println();
        System.out.println(ans.get(ans.size() - 1));
    }

    private static List<Integer> div(List<Integer> nums, int num){
        List<Integer> ans = new ArrayList<>();
        int r = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            r = r * 10 + nums.get(i);
            ans.add(r / num);
            r %= num;
        }
        while (ans.size() > 1 && ans.get(0) == 0) {
            ans.remove(0);
        }
        ans.add(r);
        return ans;
    }
}
