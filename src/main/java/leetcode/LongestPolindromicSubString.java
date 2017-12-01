package leetcode;

/**
 * @author Dauren Mussa
 * @since 12/1/17
 */
public class LongestPolindromicSubString {

    public static void main(String[] args) {
        LongestPolindromicSubString longestPolindromicSubString = new LongestPolindromicSubString();

        System.out.println(longestPolindromicSubString.longestPalindrome("aabaca"));
    }

    public String longestPalindrome(String s) {
        int startLength = s.length();
        int start = 0;
        int end = s.length()-1;
        while (true) {
            //validating
            int i = start;
            int j = end;
            while (i<j && s.charAt(i)==s.charAt(j)) {
                i++;
                j--;
            }

            if (i==j || i-j == 1) {
                return s.substring(start, end+1);
            }


            if (end == s.length()-1) {
                startLength--;
                start = 0;
                end = start+startLength;
            } else {
                start++;
                end++;
            }
        }
    }

}
