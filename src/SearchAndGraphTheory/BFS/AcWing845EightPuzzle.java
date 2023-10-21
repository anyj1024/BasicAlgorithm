package SearchAndGraphTheory.BFS;

import java.util.*;

/**
 * @description: Eight Puzzle
 * @author: anyj1024
 * @date: 2023/10/21
 */
public class AcWing845EightPuzzle {
    public static void swap(char[] arr,int x,int y){
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static int bfs(String start ,String end){
        Map<String,Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        q.offer(start);
        map.put(start,0);

        int[] dx = {-1,0,1,0},dy = {0,1,0,-1};
        while(!q.isEmpty()){
            String t = q.poll();

            int k  = t.indexOf('x');
            int x = k / 3 ; int y = k % 3;

            if(t.equals(end)) return map.get(t);
            for(int i = 0 ; i < 4 ;  i ++ ){
                int a = x + dx[i],b = y + dy[i];
                if(a >= 0 && a < 3 && b >= 0 && b < 3){
                    char[] arr = t.toCharArray();
                    swap(arr, k, a * 3 + b);
                    String str = new String(arr);
                    if(map.get(str) == null){
                        map.put(str,map.get(t) + 1);
                        q.offer(str);
                    }
                }

            }

        }
        return -1;

    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String start = "";
        for(int i = 0 ; i < 9 ; i ++ ){
            String s = scan.next();
            start += s;
        }
        String end = "12345678x";
        System.out.println(bfs(start,end));
    }
}
