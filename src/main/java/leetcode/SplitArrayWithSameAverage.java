package leetcode;

/**
 * @author Dauren Mussa
 * @since 5/15/18
 */
public class SplitArrayWithSameAverage {

    public static void main(String[] args) {
        SplitArrayWithSameAverage splitArrayWithSameAverage = new SplitArrayWithSameAverage();

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(splitArrayWithSameAverage.splitArraySameAverage(array));

        final Character NULL_CHAR = null;
        String nullString = null;
        Character someChar = nullString != null && nullString.length() > 0 ? nullString.charAt(0) : NULL_CHAR;

        System.out.println(someChar);

    }

    public boolean splitArraySameAverage(int[] A) {
        return false;
    }

}
