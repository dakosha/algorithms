package amazon;


import java.util.Stack;

/**
 * @author Dauren Mussa
 * @since 1/25/18
 */
public class Coins {

    private static int total = 0;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        int n = 25;
        int[] coins = new int[]{25, 10, 5, 1};
        change(coins, n, 0);
        System.out.println(total);
    }

    private static void change(int[] coins, int n, int index) {
        if (n == 0) {
            System.out.println(stack.toString());
            total++;
        } else {
            for (int i = index; i < coins.length; i++) {
                if (n - coins[i] >= 0 && (stack.isEmpty() || stack.peek() >= coins[i])) {
                    stack.push(coins[i]);
                    change(coins, n - coins[i], i);
                    stack.pop();
                }
            }
        }
    }

}
