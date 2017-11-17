package codewar.hackerrank;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

/**
 * @author Dauren Mussa
 * @since 5/20/17
 */
public class StringToCompare {

    public static void main(String[] args) {
        String[] arrayA = new String[1];
        String[] arrayB = new String[1];
        arrayA[0] = "aaaa";
        arrayB[0] = "aabb";
        int[] result = getMinimumDifference(arrayA, arrayB);

    }

    static int[] getMinimumDifference(String[] a, String[] b) {
        int[] result = new int[a.length];
        for (int i=0; i<a.length; i++) {
            if (a[i].length() != b[i].length()) {
                result[i] = -1;
            }
            else {

                int[] lettersA = new int[200];
                int[] lettersB = new int[200];

                for (int j=0; j<a[i].length(); j++) {
                    int indexA = a[i].charAt(j);
                    int indexB = b[i].charAt(j);
                    lettersA[indexA] = lettersA[indexA] + 1;
                    lettersB[indexB] = lettersB[indexB] + 1;
                }

                int difference = 0;
                for (char in = 'a'; in<='z'; in++) {
                    int dif = lettersA[in] - lettersB[in];
                    if (dif >0) {
                        difference += dif;
                    }
                }

                result[i] = difference;

            }
        }
        return result;
    }

}
