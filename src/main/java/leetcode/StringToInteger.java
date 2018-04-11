package leetcode;

/**
 * @author Dauren Mussa
 * @since 2/17/18
 */
public class StringToInteger {

    public static void main(String[] args) {
        String n = "      -11919730356x";
        System.out.println(myAtoi(n));
    }

    static int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        long result = 0;
        long multi = 1;
        int shift = 0;
        if (str.charAt(0) == '-') {
            multi = multi * -1;
            shift = 1;
        } else if (str.charAt(0) == '+') {
            shift = 1;
        }
        boolean breakLoop = false;
        for (int i = shift; i < str.length(); i++) {
            char digit = str.charAt(i);
            int number = 0;
            switch (digit) {
                case '1':
                    number = 1;
                    break;
                case '2':
                    number = 2;
                    break;
                case '3':
                    number = 3;
                    break;
                case '4':
                    number = 4;
                    break;
                case '5':
                    number = 5;
                    break;
                case '6':
                    number = 6;
                    break;
                case '7':
                    number = 7;
                    break;
                case '8':
                    number = 8;
                    break;
                case '9':
                    number = 9;
                    break;
                case '0':
                    number = 0;
                    break;
                default: {
                    result = (long) (result / Math.pow(10, str.length() - i));
                    breakLoop= true;
                }
            }

            if (breakLoop) {
                break;
            }

            result += (number * Math.pow(10, str.length() - i - 1));
        }

        if (multi > 0 && result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (multi<0 && result*multi < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) (result * multi);
    }

}
