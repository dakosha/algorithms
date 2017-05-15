package codewar.hackerrank;

import java.util.Scanner;

/**
 * @author Dauren Mussa
 * @since 4/28/17
 */
public class HourGlass {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final byte[][] data = new byte[6][6];
        final byte n = 6;
        for (byte i = 0; i < n; i++) {
            for (byte j = 0; j < n; j++) {
                data[i][j] = scanner.nextByte();
            }
        }
        short max = Byte.MIN_VALUE;
        short currentSum = Short.MIN_VALUE;
        for (byte i = 0; i < n; i++) {
            for (byte j = 0; j < n; j++) {
                currentSum = hourGlassSum(i, j, data);
                if (currentSum == Short.MIN_VALUE) {
                    break;
                }
                else if (currentSum>max) {
                    max = currentSum;
                }
            }
        }
        System.out.println(max);
    }

    private static short hourGlassSum(final byte i, final byte j, final byte[][] data) {
        if (i + 2 > data.length - 1 || j + 2 > data.length - 1) {
            return Short.MIN_VALUE;
        }
        return (short) (data[i][j] + data[i][j + 1] + data[i][j + 2] +
                data[i + 1][j + 1] +
                data[i + 2][j] + data[i + 2][j + 1] + data[i + 2][j + 2]);
    }


}
