package amazon;

import java.math.BigInteger;

/**
 * @author Dauren Mussa
 * @since 1/28/18
 */
public class ZerosInFactorial {

    public static void main(String[] args) {
        int n = 99999999;
        countZeros(n);
        System.out.println();
        //zeros(n);

    }

    private static void countZeros(int n) {
        long time1 = System.nanoTime();

        long res = 1;

        long totalZeros = 0;
        for (int i = 2; i <= n; i++) {
            res = res * i;

            while (res % 10 == 0) {
                res = res / 10;
                totalZeros++;
            }

            long length = 1;
            long ind = i;
            while (ind > 0) {
                length *= 10;
                ind = ind / 10;
            }

            res = res % length;

        }

        long time2 = System.nanoTime();

        System.out.println(totalZeros + " zeros; " + " last digits " + res + "; NUMBER " + n + "; time=" + (time2 - time1));

    }

    public static void zeros(int n) {

        long time1 = System.nanoTime();

        BigInteger res = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }

        int zeros = 0;
        while (res.mod(BigInteger.valueOf(10)).equals(BigInteger.ZERO)) {
            res = res.divide(BigInteger.valueOf(10));
            zeros++;
        }

        long time2 = System.nanoTime();

        System.out.println(res + " multy " + n + "; zeros=" + zeros + "; time = " + (time2 - time1));

    }

}
