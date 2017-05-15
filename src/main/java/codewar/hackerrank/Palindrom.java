package codewar.hackerrank;

import java.util.Scanner;

/**
 * @author Dauren Mussa
 * @since 4/29/17
 */
public class Palindrom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] R1 = new long[n];
        long[] R2 = new long[n];
        for (int i = 0; i < n; i++) {
            R1[i] = scanner.nextLong();
            R2[i] = scanner.nextLong();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(count(R1[i], R2[i]));
        }
    }

    private static boolean isPolic(String num) {
        return num.substring(0, 1).equals(num.substring(num.length() - 1));
    }

    private static long getHigher(long r1) {
        String num = String.valueOf(r1);
        while (!isPolic(num)) {
            r1 += 1;
            num = String.valueOf(r1);
        }
        return r1;
    }

    private static long getLower(long r2) {
        String num = String.valueOf(r2);
        while (!isPolic(num)) {
            r2 -= 1;
            num = String.valueOf(r2);
        }
        return r2;
    }

    private static long count(long r1, long r2) {
        r1 = getHigher(r1);
        r2 = getLower(r2);
        long r11 = r1 / 10;
        long r22 = r2 / 10;
        long result = (r22 - r11) + 1;
        if (r11 == 0) {
            result += (9 - r1);
        }
        if (result <= 0) {
            result = 0;
        }
        return result;
    }

}
