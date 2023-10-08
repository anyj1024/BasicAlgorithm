package DataStructure.Queue;

import java.util.Scanner;

/**
 * @description: Simulation Queue
 * @author: anyj1024
 * @date: 2023/10/8
 */
public class AcWing829SimulationQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] queue = new int[100001];
        int head = 0, tail = -1;
        while (n-- > 0) {
            String s = sc.next();
            if (s.equals("push")) {
                int x = sc.nextInt();
                queue[++tail] = x;
            } else if (s.equals("pop")) {
                head++;
            } else if (s.equals("empty")) {
                if (head <= tail) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            } else {
                System.out.println(queue[head]);
            }
        }
    }
}
