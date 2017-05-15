package codewar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dauren Mussa
 * @since 12/16/16
 */
public class RemovedNumbers {

    public static void main(String[] args) {
        List<long[]> res = removNb(1000003);
        for (int i=0; i<res.size(); i++) {
            System.out.println(res.get(i)[0] + " " + res.get(i)[1]);
        }
    }

    public static List<long[]> removNb(long n) {
        List<long[]> result = new ArrayList<>();
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        for (long i = 1; i <= n; i++) {

            long newSum2 = 0;
            long j = ((sum-i) / i);
            if (i < j) {
                for (; j > i; j--) {
                    long newSum = sum - i - j;
                    if (newSum == i * j && i < n && j < n) {
                        result.add(new long[]{i, j});
                    } else {
                        if (newSum2 == 0) {
                            newSum2 = newSum;
                        } else {
                            if (newSum2 < newSum) {
                                break;
                            }
                        }
                    }
                }
            } else {
                for (; j < i; j++) {
                    long newSum = sum - i - j;
                    if (newSum == i * j && i < n && j < n) {
                        result.add(new long[]{i, j});
                    } else {
                        if (newSum2 == 0) {
                            newSum2 = newSum;
                        } else {
                            if (newSum2 > newSum) {
                                break;
                            }
                        }
                    }
                }
            }

        }

        return result;
    }
}
