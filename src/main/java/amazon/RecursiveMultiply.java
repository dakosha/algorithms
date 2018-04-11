package amazon;

/**
 * @author Dauren Mussa
 * @since 1/25/18
 */
public class RecursiveMultiply {

    public static void main(String[] args) {
        long a = 123;
        long b = 321;
        System.out.println(multiply(a, b));
    }

    public static long multiply(long a, long b) {
        long result1 = a * b;

        //sum
        long result2 = 0;
        for (long i = 0; i < b; i++) {
            result2 += a;
        }

        //bit shift
        long result3 = a;
        int powRes = 2;
        do {
            result3 = result3 << 1;
            powRes *= 2;
        } while (powRes <= b);

        powRes /= 2;

        b = b - powRes;
        for (int i = 0; i < b; i++) {
            result3 += a;
        }

        if (result1 == result2 && result1 == result3) {
            return result3;
        }

        return -1;
    }

}
