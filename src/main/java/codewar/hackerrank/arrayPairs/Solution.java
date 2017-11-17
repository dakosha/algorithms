package codewar.hackerrank.arrayPairs;

import java.util.Scanner;

/**
 * @author Dauren Mussa
 * @since 5/21/17
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
            if (i > 0) {
                if (array[i] == array[i - 1]) {
                    System.out.println(array[i]);
                }
            }
        }

        System.out.println(solve(array));
    }

    static long solve(long[] a) {
        long max = a[0];
        long result = 0;
        long iterationResult = 0;
        for (int i = 0; i < a.length - 1; i++) {
            max = a[i];
            iterationResult = 0;

            if (a[i] == 1) {
                result += (a.length - (i + 1));
            } else {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] > max) {
                        max = a[j];
                    }

                    if (a[i] * a[j] <= max) {
                        iterationResult++;
                    }
                }

                result += iterationResult;

                while (i + 1 < a.length && a[i] == a[i + 1]) {
                    i++;
                    if (iterationResult > 0) {
                        result += (--iterationResult);
                    }
                }
            }

        }

        return result;
    }


}
