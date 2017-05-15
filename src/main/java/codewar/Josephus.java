package codewar;

/**
 * @author Dauren Mussa
 * @since 12/16/16
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Josephus {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list = josephusPermutation(list, 3);

        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> result = new ArrayList<>();
        int startIndex = -1;
        boolean endFlag = false;
        boolean[] flags = new boolean[items.size()];

        while (result.size() < items.size()) {
            int i = 0;

            while (i < k) {
                startIndex++;
                if (startIndex == items.size()) {
                    startIndex = 0;
                }
                if (!flags[startIndex]) {
                    i++;
                }
            }

            flags[startIndex] = true;
            result.add(items.get(startIndex));
        }

        return result;
    }

}