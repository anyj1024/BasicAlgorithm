package DataStructure.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @description: Monotonic Stack
 * @author: anyj1024
 * @date: 2023/10/8
 */
public class AcWing830MonotonicStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) System.out.print("-1 ");
            else System.out.print(nums[stack.peek()] + " ");
            stack.push(i);
        }
    }
}
