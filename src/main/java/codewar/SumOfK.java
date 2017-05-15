package codewar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Dauren Mussa
 * @since 12/15/16
 */
public class SumOfK {

    private static int max = 0;
    private static int maxTime = 0;

    public static void main(String[] args) {
        System.out.println("****** Basic Tests small numbers******");
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        int n = SumOfK.chooseBestSum(163, 3, ts);
        assertEquals(163, n);
        ts = new ArrayList<>(Arrays.asList(50));
        Integer m = SumOfK.chooseBestSum(163, 3, ts);
        assertEquals(null, m);
        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        n = SumOfK.chooseBestSum(230, 3, ts);
        assertEquals(228, n);
    }

    public static Integer chooseBestSum(int time, int cities, List<Integer> list) {
        if (time < 0 ||
                cities <= 0 ||
                list == null || list.size() < 1 ||
                list.size() < cities) {
            return null;
        }

        max = 0;
        maxTime = time;

        Integer[] array = new Integer[list.size()];
        list.toArray(array);

        findSum(array, 0, cities - 1, 0);

        if (max == 0) {
            return null;
        }

        return max;
    }

    private static void findSum(Integer[] array, Integer begin, Integer end, Integer sum) {
        if (end >= 0) {
            for (int i = begin; i < array.length - end; i++) {
                if (array[i] != null && array[i] > 0) {
                    findSum(array, i + 1, end - 1, sum + array[i]);
                }
            }
        }
        else {
            if (sum > max && sum <= maxTime) {
                max = sum;
            }
        }
    }

}