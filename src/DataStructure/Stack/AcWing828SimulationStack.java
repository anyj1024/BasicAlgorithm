package DataStructure.Stack;

import java.util.Scanner;

/**
 * @description: Simulation Stack
 * @author: anyj1024
 * @date: 2023/10/7
 */
public class AcWing828SimulationStack {
    static final int N = 100001;
    static int[] stack = new int[N];
    static int head = 0;
    static void push(int x) {
        stack[head++] = x;
    }
    static int pop() {
        return stack[--head];
    }
    static boolean isEmpty() {
        return head == 0;
    }
    static int peek() {
        return stack[head - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opr;
        int n = sc.nextInt();
        while (n-- > 0) {
            opr = sc.next();
            switch (opr) {
                case "push":
                    push(sc.nextInt());
                    break;
                case "pop":
                    pop();
                    break;
                case "empty":
                    System.out.println(isEmpty() ? "YES" : "NO");
                    break;
                case "query":
                    System.out.println(peek());
                    break;
            }
        }
    }

}
