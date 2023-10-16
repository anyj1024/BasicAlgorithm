package DataStructure.Heap;

import java.util.Scanner;

/**
 * @description: Simulation Heap
 * @author: anyj1024
 * @date: 2023/10/16
 */
public class AcWing840SimulationHeap {
    static int N = 100010,size,m;
    static int[] h = new int[N];
    static int[] hp = new int[N];
    static int[] ph = new int[N];
    public static void swap(int[] a,int x,int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    public static void head_swap(int x,int y){
        swap(ph,hp[x],hp[y]);
        swap(hp,x,y);
        swap(h,x,y);
    }
    public static void down(int x){
        int t = x;
        if(x * 2 <= size && h[x * 2] < h[t]) t = x * 2;
        if(x *2 + 1 <= size && h[x * 2 + 1] < h[t]) t = x * 2 + 1;
        if(t != x){
            head_swap(x,t);
            down(t);
        }
    }
    public static void up(int x){
        while(x / 2 > 0 && h[x / 2] > h[x]){
            head_swap(x,x/2);
            x = x / 2;
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        size = 0;
        m = 0;
        while(n -- > 0){
            String s = scan.next();
            if(s.equals("I")){
                int x= scan.nextInt();
                size ++;m ++;
                ph[m] = size;hp[size] = m;
                h[size] = x;
                up(size);
            }else if(s.equals("PM")){
                System.out.println(h[1]);
            }else if(s.equals("DM")){
                head_swap(1,size);
                size--;
                down(1);
            }else if(s.equals("D")){
                int k = scan.nextInt();
                k = ph[k];
                head_swap(k,size);
                size--;
                up(k);
                down(k);
            }else{
                int k = scan.nextInt();
                int x = scan.nextInt();
                k = ph[k];
                h[k] = x;
                up(k);
                down(k);

            }
        }
    }
}