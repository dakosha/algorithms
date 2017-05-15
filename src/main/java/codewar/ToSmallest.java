package codewar;

/**
 * @author Dauren Mussa
 * @since 12/16/16
 */
public class ToSmallest {

    public static void main(String[] args) {
        long[] res = ToSmallest.smallest(913559538339912192l);

        System.out.println(res[0]);
        System.out.println(res[1]);
        System.out.println(res[2]);
    }

    public static long[] smallest(long n) {
        String strValue = String.valueOf(n);
        int minStart = Integer.MAX_VALUE;
        int minEnd = Integer.MAX_VALUE;
        long minValue = Long.MAX_VALUE;

        for (int i = 0; i < strValue.length(); i++) {
            Character ch = strValue.charAt(i);
            String lineStr = strValue.substring(0, i) + strValue.substring(i + 1, strValue.length());

            for (int j = 0; j < lineStr.length(); j++) {
                String strCheck = lineStr.substring(0, j) + ch + lineStr.substring(j, lineStr.length());

                long compare = Long.valueOf(strCheck);

                if (compare < minValue) {
                    minValue = compare;
                    minStart = i;
                    minEnd = j;
                }
                else if (compare == minValue) {
                    if (i <= minStart && j <= minEnd && i <= j) {
                        minStart = i;
                        minEnd = j;
                    }
                }
            }

            String strCheck = lineStr + ch;

            long compare = Long.valueOf(strCheck);

            if (compare < minValue) {
                minValue = compare;
                minStart = i;
                minEnd = strCheck.length()-1;
            }
            else if (compare == minValue) {
                if (i <= minStart && strCheck.length()-1 <= minEnd && i <= strCheck.length()-1) {
                    minStart = i;
                    minEnd = strCheck.length()-1;
                }
            }

        }

        // your code
        return new long[]{minValue, minStart, minEnd};
    }
}