package DataStructure.Trie;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description: Trie String Statistics
 * @author: anyj1024
 * @date: 2023/10/10
 */
public class AcWing835TrieStringStatistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            String s = sc.next(), s1 = sc.next();
            if (s.equals("I")) {
                map.put(s1, map.getOrDefault(s1, 0) + 1);
            } else {
                System.out.println(map.getOrDefault(s1, 0));
            }
        }
    }
}
