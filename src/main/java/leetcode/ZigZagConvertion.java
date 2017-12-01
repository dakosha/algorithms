package leetcode;

/**
 * @author Dauren Mussa
 * @since 12/1/17
 */
public class ZigZagConvertion {

    public static void main(String[] args) {
        ZigZagConvertion convertion = new ZigZagConvertion();
        System.out.println(convertion.convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i=0; i<rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        int lymb = 1;

        for (int i=0; i<s.length(); i++) {
            rows[currentRow].append(s.charAt(i));

            if (currentRow+lymb>=0 && currentRow+lymb<rows.length) {
                currentRow+=lymb;

                if (currentRow==0 || currentRow==rows.length-1) {
                    lymb = -lymb;
                }
            }
        }

        for (int i=1; i<rows.length; i++) {
            rows[0].append(rows[i].toString());
        }

        return rows[0].toString();
    }

}
