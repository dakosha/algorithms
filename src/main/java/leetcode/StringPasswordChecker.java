package leetcode;

/**
 * @author Dauren Mussa
 * @since 12/1/17
 */
public class StringPasswordChecker {

    public static void main(String[] args) {
        StringPasswordChecker checker = new StringPasswordChecker();

        System.out.println(checker.strongPasswordChecker(""));
    }

    public int strongPasswordChecker(String s) {
        int length = s.length();
        int total = 0;

        int minLength = 6;
        int maxLength = 20;

        if (length < 6) {
            total += (6 - length);
        } else if (length > 20) {
            total += (length - 20);
        }



        return total;
    }

}
