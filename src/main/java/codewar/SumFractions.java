package codewar;

import java.math.BigInteger;

/**
 * @author Dauren Mussa
 * @since 12/18/16
 */
class SumFractions {

    public static void main(String[] args) {
        System.out.println(sumFracts(new int[][]{{1, 2}, {2, 9}, {3, 18}, {4, 24}, {6, 48}}));
    }

    public static String sumFracts(int[][] l) {
        if (l.length == 0) {
            return null;
        }

        BigInteger denom = BigInteger.ONE;
        for (int i = 0; i < l.length; i++) {
            if (l[i][1] == 0) {
                return null;
            }
            denom = denom.multiply(BigInteger.valueOf(l[i][1]));
        }

        BigInteger numerator = BigInteger.ZERO;

        for (int i = 0; i < l.length; i++) {
            numerator = numerator.add(denom.divide(BigInteger.valueOf(l[i][1])).multiply(BigInteger.valueOf(l[i][0])));
        }

        if (numerator.equals(BigInteger.ZERO)) {
            return String.valueOf(numerator.longValue());
        }

        BigInteger nod = nod(numerator, denom);
        if (nod.equals(BigInteger.ZERO)) {
            return null;
        }
        numerator = numerator.divide(nod);
        denom = denom.divide(nod);

        if (denom.equals(BigInteger.ONE)) {
            return String.valueOf(numerator);
        } else {
            return "[" + numerator + ", " + denom + "]";
        }
    }

    private static BigInteger nod(BigInteger n1, BigInteger n2) {
        if (n1.compareTo(n2) == 1) {
            BigInteger nod = (n1.mod(n2));
            if (nod.equals(BigInteger.ZERO)) {
                return n2;
            } else {
                return nod(n2, nod);
            }
        } else {
            BigInteger nod = n2.mod(n1);
            if (nod.equals(BigInteger.ZERO)) {
                return n1;
            } else {
                return nod(n1, nod);
            }
        }
    }

}
