package codewar;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Dauren Mussa
 * @since 12/16/16
 */
class Emirps {

    private static List<Integer> primes = new ArrayList<>();

    static {
        for (int i = 13; i < 1000000; i += 2) {
            if (i % 3 != 0 && i % 5 != 0 && i % 7 != 0 && i % 11 != 0) {
                if (BigInteger.valueOf(i).isProbablePrime((int) Math.log(i))) {
                    Integer reversed = reverseInteger(i);
                    if (i != reverseInteger(i)) {
                        if (BigInteger.valueOf(reversed).isProbablePrime((int) Math.log(reversed))) {
                            primes.add(i);
                        }
                    }
                }
            }
        }
    }

    private static Integer reverseInteger(Integer val) {
        Integer value = val;
        Integer reversedNum = 0;
        while (value != 0) {
            reversedNum = reversedNum * 10 + value % 10;
            value = value / 10;
        }
        return reversedNum;
    }

    public static void main(String[] args) {
        System.out.println(primes.size());
    }

    public static long[] findEmirp(long n) {

        Iterator<Integer> iterator = primes.iterator();
        Integer value;
        Integer max = 0;
        Integer sum = 0;
        Integer index = 0;
        while (iterator.hasNext() && (value = iterator.next()) <= n) {
            if (value > max) {
                max = value;
            }
            sum += value;
            index++;
        }

        return new long[] {index, max, sum};
    }


}
