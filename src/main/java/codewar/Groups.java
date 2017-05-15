package codewar;

import java.util.Stack;

/**
 * @author Dauren Mussa
 * @since 12/12/16
 */
public class Groups {

    public static void main(String[] args) {
        System.out.println(groupCheck("()"));
        System.out.println(groupCheck("{["));
    }

    public static boolean groupCheck(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            else {
                if (!stack.empty()) {
                    if (stack.peek() == '{' && s.charAt(i) == '}') {
                        stack.pop();
                    } else if (stack.peek() == '(' && s.charAt(i) == ')') {
                        stack.pop();
                    } else if (stack.peek() == '[' && s.charAt(i) == ']') {
                        stack.pop();
                    }
                }
                else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

}
