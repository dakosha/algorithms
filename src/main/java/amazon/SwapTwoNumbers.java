package amazon;

/**
 * @author Dauren Mussa
 * @since 1/28/18
 */
public class SwapTwoNumbers {

    public static void main(String[] args) {
        int a = 3;
        int b = 27;

        swap(a, b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println(a);
        System.out.println(b);

    }

    public static void swap(int a, int b) {
        System.out.println(a);
        System.out.println(b);
        if (a < b) {
            a = a * b;
            b = a / b + b;
            b = (b - (int) Math.sqrt(b * b - 4 * a)) / 2;
            a = (a / b);
            System.out.println(a);
            System.out.println(b);
        } else if (a > b) {
            a = a * b;
            b = a / b + b;
            b = (b + (int) Math.sqrt(b * b - 4 * a)) / 2;
            a = (a / b);
            System.out.println(a);
            System.out.println(b);
        } else {
            System.out.println(a);
            System.out.println(b);
        }
    }

}
