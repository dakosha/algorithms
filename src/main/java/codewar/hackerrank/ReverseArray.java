package codewar.hackerrank;

import java.util.Scanner;

/**
 * @author Dauren Mussa
 * @since 4/28/17
 */
public class ReverseArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        int[] data = new int[n];
        for (int i=0; i<n; i++) {
            data[i] = scanner.nextInt();
        }
        for (int i=data.length-1; i>=0; i--) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

}
