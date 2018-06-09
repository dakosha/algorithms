package crossover;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Tester {

    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method.
     */
    static boolean[] twins(String[] a, String[] b) {
        boolean[] result = new boolean[a.length];

        for (int i=0; i<result.length; i++) {
            if (a[i].length()!=b[i].length()) {
                result[i] = false;
            } else {
                result[i] = false;

                Set<Character> oddA = new HashSet<>(); //1,3,5, etc.
                Set<Character> evenA = new HashSet<>();//0,2,4, etc.

                Set<Character> oddB = new HashSet<>(); //1,3,5, etc.
                Set<Character> evenB = new HashSet<>();//0,2,4, etc.

                for (int j=0; j<a[i].length(); j++) {
                    if (j%2==0){
                        evenA.add(a[i].charAt(j));
                        evenB.add(b[i].charAt(j));
                    } else {
                        oddA.add(a[i].charAt(j));
                        oddB.add(b[i].charAt(j));
                    }
                }

                if (oddA.equals(oddB) && evenA.equals(evenB)) {
                    result[i] = true;
                }
            }
        }

        return result;
    }

    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine().trim());
        String[] a = new String[n];
        for(int i = 0; i < n; i++) {
            a[i] = in.nextLine();
        }

        int m = Integer.parseInt(in.nextLine().trim());
        String[] b = new String[m];
        for(int i = 0; i < m; i++) {
            b[i] = in.nextLine();
        }

        // call twins function
        boolean[] results = twins(a, b);

        for(int i = 0; i < results.length; i++) {
            System.out.println(results[i]? "Yes" : "No");
        }
    }
}