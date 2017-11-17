package leetcode;

/**
 * @author Dauren Mussa
 * @since 11/14/17
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int value = 1234567892;
        value = reverse(value);
        System.out.println(value);
    }

    public static int reverse(int x) {
        long reversed = 0;
        int m;

        m = x;

        while (x > 0 ? m > 0 : m < 0) {
            reversed = reversed + (x > 0 ? m % 10 : m % -10);
            m /= 10;

            if (x > 0 ? m > 0 : m < 0) {
                reversed *= 10;
            }
        }

        if (reversed>Integer.MAX_VALUE || reversed <Integer.MIN_VALUE) {
            reversed = 0;
        }

        return (int)reversed;
    }

}
