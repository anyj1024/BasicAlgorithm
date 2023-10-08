package DataStructure.Stack;

import java.util.*;

/**
 * @description:
 * @author: anyj1024
 * @date: 2023/10/8
 */
public class AcWing3302ExpressionEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        Deque<Character> operations = new ArrayDeque<>();
        Deque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                int x = 0, j = i;
                while (j < str.length() && Character.isDigit(str.charAt(j))) {
                    x = x * 10 + str.charAt(j) - '0';
                    j++;
                }
                numbers.push(x);
                i = j - 1;
            } else if (ch == '(') {
                operations.push(ch);
            } else if (ch == ')') {
                while (operations.peek() != '(') {
                    evaluation(operations, numbers);
                }
                operations.pop();
            } else {
                while (!operations.isEmpty() && operations.peek() != '(' && map.get(operations.peek()) >= map.get(ch)) {
                    evaluation(operations, numbers);
                }
                operations.push(ch);
            }
        }
        while (!operations.isEmpty()) evaluation(operations, numbers);
        System.out.println(numbers.peek());
    }

    private static void evaluation(Deque<Character> operations, Deque<Integer> numbers) {
        int num2 = numbers.pop(), num1 = numbers.pop();
        char operation = operations.pop();
        switch (operation) {
            case '+':
                numbers.push(num1 + num2);
                break;
            case '-':
                numbers.push(num1 - num2);
                break;
            case '*':
                numbers.push(num1 * num2);
                break;
            case '/':
                numbers.push(num1 / num2);
                break;
        }
    }
}
