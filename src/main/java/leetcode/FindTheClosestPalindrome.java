package leetcode;

/**
 * @author Dauren Mussa
 * @since 11/20/17
 */
public class FindTheClosestPalindrome {

    public static void main(String[] args) {
        FindTheClosestPalindrome findTheClosestPalindrome = new FindTheClosestPalindrome();

        System.out.println(findTheClosestPalindrome.nearestPalindromic("1234"));
    }

    public String nearestPalindromic(String n) {

        if (n.length()==0) {

        }

        String result1 = "";
        String result2 = "";
        for (int i = 0; i <= n.length() / 2 - 1; i++) {
            result1 = result1 + n.charAt(i);
            result2 = n.charAt(i) + result2;
        }
        if (n.length() % 2 == 0) {
            return result1 + result2;
        } else {
            return result1 + n.charAt(n.length() / 2) + result2;
        }

    }

}
