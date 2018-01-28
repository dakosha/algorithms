package amazon;

/**
 * @author Dauren Mussa
 * @since 1/28/18
 */
public class FindMaximumWithoutIfThenElse {

    public static void main(String[] args) {
        int a = 10;
        int b = 7;

        System.out.println(max(a, b));
    }

    public static int max(int a, int b) {
        int c = a - b;
        System.out.println(c);
        int k = (c >> 31) & 0x1;
        System.out.println(k);
        int result = a - k * c;
        System.out.println(result);
        return result;
    }

}
