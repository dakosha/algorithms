package leetcode;

import java.util.Stack;

/**
 * @author Dauren Mussa
 * @since 2/19/18
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();

        String text = "))()()((())()(()()(())((";

        System.out.println(longestValidParentheses.longestValidParentheses(text));
    }

    public int longestValidParentheses(String s) {
        int len = s.length(), maxLen = 0, last = -1;
        if (len == 0 || len == 1)
            return 0;

        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    last = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - last);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
        }

        return maxLen;
    }

    public int longestValidParentheses2(String s) {
        int result = 0;

        Stack<Integer> values = new Stack<>();

        while (true) {
            s = s.replace("()", "2");
            System.out.println(s);

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '2') {
                    values.push(2);
                } else {
                    int newVal = 0;
                    while (values.size() > 0 && values.peek() == 2) {
                        int val = values.pop();
                        newVal += val;
                    }
                    if (newVal > 0) {
                        values.push(newVal);
                    }
                }
            }

            s = s.replace("2", "");
            System.out.println(s);

            break;
        }


        return result;
    }

    public int longestValidParentheses1(String s) {
        int result = 0;

        //Left to Right
        Stack<Character> stack = new Stack<>();
        Stack<Integer> values = new Stack<>();
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);

            if (character == '(') {
                stack.push(character);
            } else {
                if (!stack.isEmpty()) {
                    char st = stack.peek();
                    if (st == '(') {
                        current += 2;
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty()) {
                values.push(current);
                current = 0;
            }

        }
        if (current > result) {
            result = current;
        }

        return result;
    }

}
