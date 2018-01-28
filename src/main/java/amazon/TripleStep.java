package amazon;

/**
 * @author Dauren Mussa
 * @since 1/25/18
 */
public class TripleStep {

    static long[] array;

    public static void main(String[] args) {
        int n = 39;
        array = new long[n];

        long time1 = System.currentTimeMillis();

        System.out.println(steps(n));

        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);

        time1 = System.currentTimeMillis();
        System.out.println(steps2(n));
        time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }

    public static long steps2(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        } else {
            long result = 0;
            if (n >= 3) {
                result += steps2(n - 3);
            }
            if (n >= 2) {
                result += steps2(n - 2);
            }
            if (n >= 1) {
                result += steps2(n - 1);
            }
            return result;
        }
    }

    public static long steps(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        } else {
            if (array[n - 3] == 0) {
                array[n - 3] = steps(n - 3);
            }
            if (array[n - 2] == 0) {
                array[n - 2] = steps(n - 2);
            }
            if (array[n - 1] == 0) {
                array[n - 1] = steps(n - 1);
            }
            return array[n - 3] + array[n - 2] + array[n - 1];
        }
    }

}
