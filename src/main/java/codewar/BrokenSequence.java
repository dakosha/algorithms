package codewar;

/**
 * @author Dauren Mussa
 * @since 12/12/16
 */
public class BrokenSequence {

    public static void main(String[] args) {
        System.out.println(new BrokenSequence().findMissingNumber(""));
        System.out.println(new BrokenSequence().findMissingNumber("2 1 4 3 a"));
        System.out.println(new BrokenSequence().findMissingNumber("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15"));
    }

    public int findMissingNumber(String sequence) {
        if (sequence.length() == 0) {
            return 0;
        }
        byte[] map = new byte[Short.MAX_VALUE];
        int max = 0;
        int missing = 0;
        String word = "";
        for (int i = 0; i <= sequence.length(); i++) {
            if (i < sequence.length() && sequence.charAt(i) != ' ') {
                word = word + sequence.charAt(i);
            } else {
                int number = getNumber(word);
                if (number > 0) {
                    map[number]++;
                    if (max < number) {
                        max = number;
                    }
                } else {
                    return 1;
                }
                word = "";
            }
        }

        for (int i = 1; i < max; i++) {
            if (map[i] == 0) {
                return i;
            }
        }

        return missing;
    }

    public int getNumber(String word) {
        try {
            return Integer.valueOf(word);
        } catch (Exception ex) {
            return -1;
        }
    }

}
