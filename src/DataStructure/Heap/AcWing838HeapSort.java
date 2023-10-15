package DataStructure.Heap;

import java.util.Scanner;

/**
 * @description: Heap Sort.
 * @author: anyj1024
 * @date: 2023/10/15
 */
public class AcWing838HeapSort {
    static int N = 100010;
    static int[] h = new int[N];
    static int size;
    public static void swap(int x,int y){
        int temp = h[x];
        h[x] = h[y];
        h[y] = temp;
    }
    public static void down(int u){
        int t = u;
        if(u * 2 <= size && h[u * 2] < h[t]) t = u * 2;
        if(u * 2 + 1 <= size && h[u * 2 + 1] < h[t]) t = u * 2 + 1;
        if(u != t){
            swap(u,t);
            down(t);
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        for(int i = 1 ; i <= n ; i ++ ) h[i] = scan.nextInt();
        size = n;
        for(int i = n/2 ; i >= 0; --i ) down(i);

        while(m -- > 0){
            System.out.print(h[1] + " ");
            h[1] = h[size--];
            down(1);
        }
    }
}
