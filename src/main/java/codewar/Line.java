package codewar;

/**
 * @author Dauren Mussa
 * @since 12/15/16
 */
public class Line {

    public static String WhoIsNext(String[] names, int n) {
        String result = "";
        if (names != null && names.length > 0) {
            int base = names.length;
            int prevSumBase = base;
            int sumBase = base;
            int cutBase = base;
            int step = 1;
            while (sumBase < n) {
                prevSumBase = sumBase;
                sumBase = prevSumBase + cutBase * 2;
                cutBase *= 2;
                step += 1;
            }

            int realIndex = step > 1 ? n - prevSumBase : n;
            int nameStep = cutBase / base;
            if (realIndex % nameStep == 0) {
                realIndex = realIndex / nameStep - 1;
            }
            else {
                realIndex = realIndex / nameStep;
            }
            return names[realIndex];
        }

        return result;
    }

}
