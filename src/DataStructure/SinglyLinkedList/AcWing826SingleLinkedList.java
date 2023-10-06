package DataStructure.SinglyLinkedList;

import java.util.Scanner;

/**
 * @description: Single Linked List
 * @author: anyj1024
 * @date: 2023/10/6
 */
public class AcWing826SingleLinkedList {
    public static int N = 100000;
    public static int[] elements = new int[N + 1];
    public static int[] nextElements = new int[N + 1];
    public static int head = -1;
    public static int idx = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            String str = sc.next();
            if (str.equals("H")) {
                int x = sc.nextInt();
                elements[idx] = x;
                nextElements[idx] = head;
                head = idx;
                idx++;
            } else if (str.equals("I")) {
                int k = sc.nextInt(), x = sc.nextInt();
                elements[idx] = x;
                nextElements[idx] = nextElements[k - 1];
                nextElements[k - 1] = idx;
                idx++;
            } else if (str.equals("D")) {
                int k = sc.nextInt();
                if (k == 0) {
                    head = nextElements[head];
                } else {
                    nextElements[k - 1] = nextElements[nextElements[k - 1]];
                }
            }
        }
        while (head != -1) {
            System.out.print(elements[head] + " ");
            head = nextElements[head];
        }
    }
}
