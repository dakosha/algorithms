package codewar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Dauren Mussa
 * @since 12/16/16
 */
public class Decompose {

    private Stack<Long> stack = new Stack<>();
    private List<Long> result = Arrays.asList(0L);
    private String stringResult = null;

    public String decompose(long n) {
        find2(n, n * n);
        return stringResult;
    }

    private void find2(long val, long squareVal) {
        if (stringResult != null) return;
        if (squareVal == 0) {
            List<Long> list = stack;
            if (list.get(list.size() - 1) > result.get(result.size() - 1)) {
                result = new ArrayList<>();
                stringResult = "";
                for (int i = 0; i < list.size(); i++) {
                    result.add(list.get(list.size() - i - 1));
                    stringResult += " " + list.get(list.size() - i - 1);
                }
                stringResult = stringResult.trim();
            }
        }
        for (long i = val - 1; i > 0; i--) {
            if (i * i <= squareVal && (stack.isEmpty() || stack.peek() > i)) {
                stack.push(i);
                find2((long) Math.sqrt(squareVal - i * i) + 1, squareVal - i * i);
                stack.pop();
            }
        }
    }

}
