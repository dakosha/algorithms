package codewar.hackerrank;

import java.util.Scanner;

/**
 * @author Dauren Mussa
 * @since 4/29/17
 */
public class ExcelNumber {

    private static int buf = 64;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(getColumnName(numbers[i]));
        }

    }

    private static String getColumnName(int number) {
        int current = number;
        String result = "";
        while (current > 0) {
            int div = current % 26;
            current = current / 26;
            if (div == 0) {
                div = 26;
                current = current - 1;
            }
            result = new Character((char) (div + buf)).toString() + result;
        }
        return result;
    }

}
