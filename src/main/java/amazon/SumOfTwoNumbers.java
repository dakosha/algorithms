package amazon;

/**
 * @author Dauren Mussa
 * @since 2/6/18
 */
public class SumOfTwoNumbers {

    public static void main(String[] args) {
        int a = 10, b = 5;
        System.out.println(sum(a, b));
    }

    public static int sum(int a, int b) {
        if (a == 0) return b;
        int sum = a ^ b;
        int cary = (a & b) << 1;
        return sum(cary, sum);
    }

}
