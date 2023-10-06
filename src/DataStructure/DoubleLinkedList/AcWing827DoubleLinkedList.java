package DataStructure.DoubleLinkedList;

import java.util.Scanner;

/**
 * @description: Doubled Linked List
 * @author: anyj1024
 * @date: 2023/10/6
 */
public class AcWing827DoubleLinkedList {
    public static int N = 100000;
    public static int[] elements = new int[N + 1];
    public static int[] lefts = new int[N + 1];
    public static int[] rights = new int[N + 1];
    public static int idx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        rights[0] = 1;
        lefts[1] = 0;
        idx = 2;
        while (n-- > 0) {
            String s = sc.next();
            char operation = s.charAt(0);
            if (operation == 'L') {
                int x = sc.nextInt();
                insert(0, x);
            } else if (operation == 'R') {
                int x = sc.nextInt();
                insert(lefts[1], x);
            } else if (operation == 'D') {
                int k = sc.nextInt();
                delete(k + 1);
            } else if (s.equals("IR")) {
                int k = sc.nextInt(), x = sc.nextInt();
                insert(k + 1, x);
            } else {
                int k = sc.nextInt(), x = sc.nextInt();
                insert(lefts[k + 1], x);
            }
        }
        for (int i = rights[0]; i != 1; i = rights[i]) {
            System.out.print(elements[i] + " ");
        }
    }

    private static void delete(int k) {
        rights[lefts[k]] = rights[k];
        lefts[rights[k]] = lefts[k];
    }

    private static void insert(int k, int x) {
        elements[idx] = x;
        rights[idx] = rights[k];
        lefts[idx] = k;
        lefts[rights[k]] = idx;
        rights[k] = idx;
        idx++;
    }
}