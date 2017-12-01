package leetcode;

/**
 * @author Dauren Mussa
 * @since 11/30/17
 */
public class LongestSubStringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingCharacters longestSubStringWithoutRepeatingCharacters = new LongestSubStringWithoutRepeatingCharacters();


        System.out.println(longestSubStringWithoutRepeatingCharacters.lengthOfLongestSubstring("ggububgvfk"));
    }

    public int lengthOfLongestSubstring(String s) {
        int startIndex = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            String subString = s.substring(startIndex, i);
            int position = subString.indexOf(currentChar);
            if (position > -1) {
                if (max <= subString.length()) {
                    max = subString.length();
                }
                startIndex = position + 1 + startIndex;
            } else {
                if (i == s.length() - 1) {
                    subString = s.substring(startIndex);
                    if (max <= subString.length()) {
                        max = subString.length();
                    }
                }
            }
        }

        return max;
    }

}
